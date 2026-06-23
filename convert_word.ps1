# PowerShell script to convert Markdown to DOCX using Word COM
param(
    [string]$InputFile = "MANUAL_BOOK_DRAFT.md",
    [string]$OutputFile = "MANUAL_BOOK_APLIKASI_GAJI_KARYAWAN_PT_SINTORY.docx"
)

# Get full paths
$InputPath = Join-Path (Get-Location) $InputFile
$OutputPath = Join-Path (Get-Location) $OutputFile

Write-Host "Converting $InputPath to $OutputPath..."

# Create Word application
$word = New-Object -ComObject Word.Application
$word.Visible = $false

try {
    # Create new document
    $doc = $word.Documents.Add()
    
    # Read markdown content
    $content = Get-Content $InputPath -Raw -Encoding UTF8
    $lines = $content -split "`n"
    
    Write-Host "Processing $($lines.Count) lines..."
    
    $i = 0
    $totalLines = $lines.Count
    
    while ($i -lt $totalLines) {
        $line = $lines[$i].Trim()
        
        # Progress
        if ($i % 50 -eq 0) {
            Write-Host "Processing line $i of $totalLines..."
        }
        
        # Skip empty lines
        if ([string]::IsNullOrWhiteSpace($line)) {
            $i++
            continue
        }
        
        # Headers
        if ($line -match '^# (.+)$') {
            $para = $doc.Content.Paragraphs.Add()
            $para.Range.Text = $matches[1]
            $para.Range.Font.Size = 20
            $para.Range.Font.Bold = $true
            $para.Alignment = 1  # Center
            $para.Range.InsertParagraphAfter()
        }
        elseif ($line -match '^## (.+)$') {
            $para = $doc.Content.Paragraphs.Add()
            $para.Range.Text = $matches[1]
            $para.Range.Font.Size = 16
            $para.Range.Font.Bold = $true
            $para.Range.InsertParagraphAfter()
        }
        elseif ($line -match '^### (.+)$') {
            $para = $doc.Content.Paragraphs.Add()
            $para.Range.Text = $matches[1]
            $para.Range.Font.Size = 14
            $para.Range.Font.Bold = $true
            $para.Range.InsertParagraphAfter()
        }
        # Placeholders - make them red and bold
        elseif ($line -match '\[PLACEHOLDER') {
            $para = $doc.Content.Paragraphs.Add()
            $para.Range.Text = $line
            $para.Range.Font.Bold = $true
            $para.Range.Font.Color = 255  # Red
            $para.Range.InsertParagraphAfter()
        }
        # Tables
        elseif ($line -match '^\|' -and ($i + 1) -lt $totalLines -and $lines[$i + 1] -match '^\|') {
            # Collect table lines
            $tableLines = @()
            while ($i -lt $totalLines -and $lines[$i].Trim() -match '^\|') {
                $tableLines += $lines[$i].Trim()
                $i++
            }
            $i--
            
            # Remove separator line
            if ($tableLines.Count -gt 1 -and $tableLines[1] -match '\-\-\-') {
                $tableLines = $tableLines[0] + $tableLines[2..($tableLines.Count - 1)]
            }
            
            if ($tableLines.Count -gt 0) {
                # Parse columns
                $cols = ($tableLines[0] -split '\|' | Where-Object { $_.Trim() -ne '' }).Count
                $rows = $tableLines.Count
                
                # Add table
                $range = $doc.Content
                $range.Collapse(0)  # Collapse to end
                $table = $doc.Tables.Add($range, $rows, $cols)
                $table.Borders.Enable = $true
                
                for ($r = 0; $r -lt $rows; $r++) {
                    $cells = $tableLines[$r] -split '\|' | Where-Object { $_.Trim() -ne '' }
                    for ($c = 0; $c -lt [Math]::Min($cols, $cells.Count); $c++) {
                        $table.Cell($r + 1, $c + 1).Range.Text = $cells[$c].Trim()
                        if ($r -eq 0) {
                            $table.Cell($r + 1, $c + 1).Range.Font.Bold = $true
                        }
                    }
                }
                
                $range.InsertParagraphAfter()
            }
        }
        # Code blocks
        elseif ($line -match '^```') {
            $codeLines = @()
            $i++
            while ($i -lt $totalLines -and $lines[$i].Trim() -notmatch '^```') {
                $codeLines += $lines[$i]
                $i++
            }
            
            if ($codeLines.Count -gt 0) {
                $para = $doc.Content.Paragraphs.Add()
                $para.Range.Text = ($codeLines -join "`n")
                $para.Range.Font.Name = "Consolas"
                $para.Range.Font.Size = 9
                $para.Range.InsertParagraphAfter()
            }
        }
        # Horizontal rules
        elseif ($line -eq '---') {
            $para = $doc.Content.Paragraphs.Add()
            $para.Range.Text = "_" * 50
            $para.Range.InsertParagraphAfter()
        }
        # Regular text
        else {
            $para = $doc.Content.Paragraphs.Add()
            # Handle bold text
            if ($line -match '\*\*(.+?)\*\*') {
                $para.Range.Text = $line -replace '\*\*', ''
            } else {
                $para.Range.Text = $line
            }
            $para.Range.InsertParagraphAfter()
        }
        
        $i++
    }
    
    # Save document
    Write-Host "Saving document..."
    $doc.SaveAs([ref]$OutputPath, [ref]16)  # 16 = wdFormatDocumentDefault (.docx)
    $doc.Close()
    
    Write-Host "Document created successfully: $OutputPath"
    
} catch {
    Write-Host "Error: $_"
} finally {
    # Cleanup
    $word.Quit()
    [System.Runtime.Interopservices.Marshal]::ReleaseComObject($word) | Out-Null
    [System.GC]::Collect()
    [System.GC]::WaitForPendingFinalizers()
}
