"""
Simple chunked converter for Markdown to DOCX
"""
from docx import Document
from docx.shared import Pt, RGBColor
from docx.enum.text import WD_ALIGN_PARAGRAPH

def convert_md_to_docx(md_file, output_file):
    doc = Document()
    
    # Set default font
    style = doc.styles['Normal']
    style.font.name = 'Calibri'
    style.font.size = Pt(11)
    
    # Read file with proper encoding
    try:
        with open(md_file, 'r', encoding='utf-8') as f:
            lines = f.readlines()
    except:
        with open(md_file, 'r', encoding='utf-8-sig') as f:
            lines = f.readlines()
    
    print(f"Processing {len(lines)} lines...")
    
    i = 0
    while i < len(lines):
        line = lines[i].rstrip()
        
        if i % 100 == 0:
            print(f"Progress: {i}/{len(lines)}")
        
        # Skip empty
        if not line:
            i += 1
            continue
        
        # H1
        if line.startswith('# '):
            p = doc.add_heading(line[2:], level=1)
            p.alignment = WD_ALIGN_PARAGRAPH.CENTER
        # H2
        elif line.startswith('## '):
            doc.add_heading(line[3:], level=2)
        # H3
        elif line.startswith('### '):
            doc.add_heading(line[4:], level=3)
        # Placeholder
        elif '[PLACEHOLDER' in line:
            p = doc.add_paragraph(line)
            for run in p.runs:
                run.font.bold = True
                run.font.color.rgb = RGBColor(255, 0, 0)
        # Table
        elif line.startswith('|') and i + 1 < len(lines) and lines[i+1].startswith('|'):
            table_lines = []
            while i < len(lines) and lines[i].strip().startswith('|'):
                table_lines.append(lines[i].strip())
                i += 1
            i -= 1
            
            # Remove separator
            if len(table_lines) > 1 and '---' in table_lines[1]:
                table_lines.pop(1)
            
            if table_lines:
                cols = len([c for c in table_lines[0].split('|') if c.strip()])
                table = doc.add_table(rows=len(table_lines), cols=cols)
                table.style = 'Light Grid Accent 1'
                
                for r, tline in enumerate(table_lines):
                    cells = [c.strip() for c in tline.split('|') if c.strip()]
                    for c, text in enumerate(cells):
                        if c < cols:
                            table.rows[r].cells[c].text = text
                            if r == 0:
                                for para in table.rows[r].cells[c].paragraphs:
                                    for run in para.runs:
                                        run.font.bold = True
        # Code block
        elif line.startswith('```'):
            code = []
            i += 1
            while i < len(lines) and not lines[i].startswith('```'):
                code.append(lines[i].rstrip())
                i += 1
            if code:
                p = doc.add_paragraph('\n'.join(code))
                for run in p.runs:
                    run.font.name = 'Consolas'
                    run.font.size = Pt(9)
        # Separator
        elif line == '---':
            doc.add_paragraph('_' * 50)
        # Bold line
        elif line.startswith('**') and line.endswith('**'):
            p = doc.add_paragraph()
            run = p.add_run(line[2:-2])
            run.font.bold = True
        # Regular
        else:
            doc.add_paragraph(line)
        
        i += 1
    
    doc.save(output_file)
    print(f"Saved: {output_file}")

if __name__ == "__main__":
    convert_md_to_docx(
        "MANUAL_BOOK_DRAFT_CLEAN.md",
        "MANUAL_BOOK_APLIKASI_GAJI_KARYAWAN_PT_SINTORY.docx"
    )
