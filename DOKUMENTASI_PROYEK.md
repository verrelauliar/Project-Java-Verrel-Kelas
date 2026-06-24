# Dokumentasi Aplikasi Gaji Karyawan

## Deskripsi Aplikasi

Aplikasi Gaji Karyawan adalah sistem manajemen penggajian berbasis desktop yang dibangun menggunakan Java Swing. Aplikasi ini mengelola data karyawan, pekerjaan, dan perhitungan gaji dengan sistem autentikasi dan laporan yang dapat dicetak.

### Fitur Utama
- Manajemen data karyawan (CRUD)
- Manajemen data pekerjaan (CRUD)
- Perhitungan gaji berdasarkan pekerjaan
- Sistem login dengan enkripsi MD5
- Laporan gaji dalam format PDF menggunakan JasperReports
- Klasifikasi gaji (A-E) dan status UMR

---

## Teknologi yang Digunakan

- **JDK**: 24 atau versi kompatibel
- **Database**: MySQL (port 3305)
- **Library**:
  - JasperReports 6.21.5+
  - Commons Collections 4-4.5.0+
  - MySQL Connector Java (JDBC) 9.3.0+
- **Framework**: Java Swing (GUI)

---

## Struktur Proyek

```
src/
├── model/                          # Model data dan logika bisnis
│   ├── Koneksi.java               # Koneksi database
│   ├── Enkripsi.java              # Enkripsi password
│   ├── Karyawan.java              # Model karyawan
│   ├── Pekerjaan.java             # Model pekerjaan
│   └── Gaji.java                  # Model gaji
│
├── id.verrel.pertemuan1/          # Form utama dan laporan
│   ├── FormUtama.java             # Menu utama aplikasi
│   ├── FormLaporanGaji.java       # Laporan gaji
│   └── FormCetak*.java            # Form cetak data
│
├── id.verrel.pertemuan2/          # Manajemen karyawan
│   ├── FormKaryawan.java          # Input/edit karyawan
│   └── FormLihatKaryawan.java     # Daftar karyawan
│
├── id.verrel.pertemuan3/          # Manajemen pekerjaan
│   ├── FormPekerjaan.java         # Input/edit pekerjaan
│   ├── FormLihatPekerjaan.java    # Daftar pekerjaan
│   └── PesanDialog.java           # Dialog konfirmasi
│
├── id.verrel.pertemuan4/          # Input gaji
│   └── FormGaji.java              # Form input gaji
│
├── id.verrel.pertemuan5/          # Controller layer
│   ├── LoginController.java       # Kontrol autentikasi
│   ├── KaryawanController.java    # Kontrol karyawan
│   ├── PekerjaanController.java   # Kontrol pekerjaan
│   └── GajiController.java        # Kontrol gaji
│
└── id.verrel.pertemuan6/          # Autentikasi
    └── FormLogin.java             # Form login
```

---

## Komponen Kritis

### 1. Koneksi Database (model/Koneksi.java)
**Lokasi**: `src/model/Koneksi.java`

Mengelola koneksi ke MySQL database.

**Konfigurasi**:
- Driver: `com.mysql.cj.jdbc.Driver`
- URL: `jdbc:mysql://localhost:3305/dbaplikasigajikaryawan`
- User: `root`
- Password: (kosong)

**Method Penting**:
- `getConnection()`: Membuat koneksi baru ke database
- `getPesanKesalahan()`: Mendapatkan pesan error koneksi

### 2. Enkripsi Password (model/Enkripsi.java)
**Lokasi**: `src/model/Enkripsi.java`

Mengamankan password pengguna menggunakan hash MD5.

**Method**:
- `hashMD5(String value)`: Mengkonversi string menjadi hash MD5

**Catatan**: MD5 digunakan untuk pembelajaran, pada produksi sebaiknya gunakan bcrypt atau Argon2.

---

## Model Data

### 1. Karyawan (model/Karyawan.java)
**Lokasi**: `src/model/Karyawan.java:18`

Mengelola data karyawan dalam tabel `tbkaryawan`.

**Atribut**:
- `ktp` (String): Nomor KTP sebagai primary key
- `nama` (String): Nama karyawan
- `ruang` (int): Nomor ruang/departemen
- `password` (String): Password terenkripsi MD5

**Method CRUD**:
- `simpan()`: Insert/update data karyawan dengan konfirmasi
- `baca(String ktp)`: Membaca data berdasarkan KTP
- `bacaData()`: Membaca semua data untuk ditampilkan di tabel
- `hapus(String ktp)`: Menghapus data karyawan

**Fitur Khusus**:
- Menggunakan PreparedStatement untuk keamanan SQL injection
- Konfirmasi dialog saat data sudah ada
- Validasi data sebelum simpan

### 2. Pekerjaan (model/Pekerjaan.java)
**Lokasi**: `src/model/Pekerjaan.java:17`

Mengelola data pekerjaan dalam tabel `tbpekerjaan`.

**Atribut**:
- `kodePekerjaan` (String): Kode pekerjaan (primary key)
- `namaPekerjaan` (String): Nama pekerjaan
- `jumlahTugas` (int): Jumlah tugas yang dikerjakan

**Method CRUD**:
- `simpan()`: Insert/update pekerjaan dengan konfirmasi
- `baca(String kodePekerjaan)`: Membaca data berdasarkan kode
- `bacaData()`: Membaca semua pekerjaan untuk dropdown/tabel
- `hapus(String kodePekerjaan)`: Menghapus pekerjaan

**Fitur Khusus**:
- Validasi kode pekerjaan unik
- Konfirmasi update jika data sudah ada

### 3. Gaji (model/Gaji.java)
**Lokasi**: `src/model/Gaji.java:27`

Mengelola data gaji karyawan dalam tabel `tbgaji`. Model paling kompleks dengan fitur pelaporan.

**Atribut**:
- `ktp` (String): Nomor KTP karyawan
- `listGaji` (Object[][]): Array berisi:
  - kodepekerjaan
  - gajibersih
  - gajikotor
  - tunjangan

**Method Utama**:
- `simpan()`: Menyimpan multiple gaji untuk satu karyawan
- `baca(String ktp)`: Membaca semua gaji karyawan
- `cetakLaporan(int ruang)`: Generate laporan PDF dengan JasperReports

**Perhitungan Gaji**:
```
Gaji Pokok = (Gaji Bersih + Gaji Kotor + Tunjangan) / 3
```

**Klasifikasi Gaji**:
- A: >= Rp 5.000.000
- B: >= Rp 4.000.000
- C: >= Rp 3.000.000
- D: >= Rp 2.000.000
- E: < Rp 2.000.000

**Status UMR**:
- "UMR": Gaji pokok >= Rp 1.000.000
- "Tidak UMR": Gaji pokok < Rp 1.000.000

**Fitur Laporan**:
- Query join 3 tabel (tbkaryawan, tbpekerjaan, tbgaji)
- Filter berdasarkan ruang (optional)
- Export ke PDF menggunakan JasperReports
- Menampilkan nama, pekerjaan, dan detail gaji

---

## Controller Layer

### 1. LoginController (id.verrel.pertemuan5/LoginController.java)
**Lokasi**: `src/id/verrel/pertemuan5/LoginController.java:16`

Menangani autentikasi pengguna.

**Method**:
- `validasi(JTextField userIdTextField, JPasswordField passwordField)`: Validasi login

**Alur Kerja**:
1. Cek user ID (KTP) tidak kosong
2. Baca data karyawan dari database
3. Hash password input dengan MD5
4. Bandingkan dengan password tersimpan
5. Set tipe user jika valid

### 2. KaryawanController
**Lokasi**: `src/id/verrel/pertemuan5/KaryawanController.java`

Mengatur logika form karyawan, validasi input, dan komunikasi dengan model Karyawan.

### 3. PekerjaanController
**Lokasi**: `src/id/verrel/pertemuan5/PekerjaanController.java`

Mengatur logika form pekerjaan dan validasi data pekerjaan.

### 4. GajiController
**Lokasi**: `src/id/verrel/pertemuan5/GajiController.java`

Mengatur input gaji multiple untuk satu karyawan dan kalkulasi gaji.

---

## Form/View Layer

### 1. FormLogin (id.verrel.pertemuan6/FormLogin.java)
Form autentikasi awal sebelum masuk aplikasi.

### 2. FormUtama (id.verrel.pertemuan1/FormUtama.java)
Menu utama aplikasi dengan navigasi ke semua fitur.

### 3. FormKaryawan (id.verrel.pertemuan2/FormKaryawan.java)
Form input/edit data karyawan dengan field:
- KTP
- Nama
- Ruang
- Password

### 4. FormLihatKaryawan (id.verrel.pertemuan2/FormLihatKaryawan.java)
Menampilkan daftar karyawan dalam tabel dengan fitur:
- View semua karyawan
- Pilih untuk edit
- Hapus data

### 5. FormPekerjaan (id.verrel.pertemuan3/FormPekerjaan.java)
Form input/edit pekerjaan dengan field:
- Kode Pekerjaan
- Nama Pekerjaan
- Jumlah Tugas

### 6. FormLihatPekerjaan (id.verrel.pertemuan3/FormLihatPekerjaan.java)
Menampilkan daftar pekerjaan dalam tabel.

### 7. FormGaji (id.verrel.pertemuan4/FormGaji.java)
Form input gaji karyawan dengan:
- Pilih karyawan (KTP)
- Multiple pekerjaan dengan detail gaji
- Gaji Bersih, Gaji Kotor, Tunjangan

### 8. FormLaporanGaji (id.verrel.pertemuan1/FormLaporanGaji.java)
Cetak laporan gaji dengan filter ruang.

---

## Database Schema

### Tabel: tbkaryawan
```sql
ktp VARCHAR (Primary Key)
nama VARCHAR
ruang INT
password VARCHAR (MD5 hash)
```

### Tabel: tbpekerjaan
```sql
kodepekerjaan VARCHAR (Primary Key)
namapekerjaan VARCHAR
jumlahtugas INT
```

### Tabel: tbgaji
```sql
ktp VARCHAR (Foreign Key -> tbkaryawan.ktp)
kodepekerjaan VARCHAR (Foreign Key -> tbpekerjaan.kodepekerjaan)
gajibersih DOUBLE
gajikotor DOUBLE
tunjangan DOUBLE
```

**Relasi**:
- tbgaji.ktp -> tbkaryawan.ktp (Many-to-One)
- tbgaji.kodepekerjaan -> tbpekerjaan.kodepekerjaan (Many-to-One)
- Satu karyawan bisa memiliki multiple pekerjaan dengan gaji berbeda

---

## Alur Aplikasi

1. **Login**: User memasukkan KTP dan password
2. **Validasi**: System hash password dan bandingkan dengan database
3. **Menu Utama**: Akses ke semua modul (Karyawan, Pekerjaan, Gaji, Laporan)
4. **Manajemen Data**: CRUD untuk karyawan dan pekerjaan
5. **Input Gaji**: Pilih karyawan, tambah multiple pekerjaan dengan detail gaji
6. **Laporan**: Generate PDF laporan gaji per ruang atau semua

---

## Catatan Pengembangan

### Kelebihan:
- Struktur MVC yang jelas (Model, View, Controller terpisah)
- Menggunakan PreparedStatement untuk keamanan
- Konfirmasi dialog untuk update data
- Laporan profesional dengan JasperReports

### Area Perbaikan:
- Ganti MD5 dengan algoritma hash modern (bcrypt, Argon2)
- Tambahkan validasi input lebih ketat
- Implementasi connection pooling untuk performa
- Tambahkan unit testing
- Refactor SQL query ke DAO pattern
- Implementasi role-based access control

---

## Cara Menjalankan

1. Install library yang dibutuhkan (lihat README.md)
2. Buat database MySQL `dbaplikasigajikaryawan` di port 3305
3. Import schema database dari folder `MySQL Database/`
4. Build project dengan NetBeans
5. Jalankan aplikasi dari main class
6. Login menggunakan KTP karyawan yang sudah terdaftar

---

**Dibuat oleh**: Verrel  
**Untuk**: Tugas Pemrograman II Semester 6
