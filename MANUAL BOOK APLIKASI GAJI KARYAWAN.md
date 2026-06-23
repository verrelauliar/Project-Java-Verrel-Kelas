## **MANUAL BOOK**

## **APLIKASI DESKTOP**

**APLIKASI GAJI KARYAWAN PT SINTORY**

**==> picture [125 x 120] intentionally omitted <==**

**----- Start of picture text -----**<br>
💼<br>**----- End of picture text -----**<br>


## **Disusun oleh:**

[Nama Lengkap Mahasiswa] [NIM] [Nama Lengkap Mahasiswa] [NIM] [Nama Lengkap Mahasiswa] [NIM]

## **PROGRAM STUDI TEKNIK INFORMATIKA**

## **FAKULTAS ILMU KOMPUTER**

## **UNIVERSITAS PAMULANG**

**2025**

## **Daftar Isi**

|Daftar Isi|i|
|---|---|
|Daftar Gambar|ii|
|TEMA|1|
|RANCANGAN LAYAR DAN PENGGUNAAN|2|
|1.1. Login|2|
|1.2. Halaman Utama|3|
|1.3. Master Data Karyawan|4|
|1.3.1.<br>Form Data Karyawan|4|
|1.3.2.<br>Dialog Lihat Karyawan|5|
|1.4. Master Data Pekerjaan|6|
|1.4.1.<br>Form Data Pekerjaan|6|
|1.4.2.<br>Dialog Lihat Pekerjaan|7|
|1.5. Transaksi Gaji|8|
|1.6. Laporan|10|
|1.6.1.<br>Laporan Gaji|10|
|1.6.2.<br>Laporan Karyawan|11|
|1.6.3.<br>Laporan Pekerjaan|11|
|STRUKTUR BERKAS|12|
|TATA CARA PENGGUNAAN SISTEM|13|
|DAFTAR PUSTAKA|14|



1

## **Daftar Gambar**

||**Daftar Gambar**||
|---|---|---|
|Gambar|1.1.1  Tampilan Form Login|2|
|Gambar|1.2.1  Tampilan Halaman Utama (Menu Bar)|3|
|Gambar|1.3.1  Tampilan Form Data Karyawan|4|
|Gambar|1.3.2  Tampilan Dialog Lihat Karyawan|5|
|Gambar|1.4.1  Tampilan Form Data Pekerjaan|6|
|Gambar|1.4.2  Tampilan Dialog Lihat Pekerjaan|7|
|Gambar|1.5.1  Tampilan Form Transaksi Gaji|8|
|Gambar|1.5.2  Tampilan Menu Popup Tabel Gaji|9|
|Gambar|1.6.1  Tampilan Laporan Gaji|10|
|Gambar|1.6.2  Tampilan Laporan Karyawan|11|
|Gambar|1.6.3  Tampilan Laporan Pekerjaan|11|
|Gambar|2.1  Struktur Berkas Proyek|12|



2

## **TEMA**

**Aplikasi Gaji Karyawan PT Sintory** merupakan sistem informasi berbasis desktop yang dirancang untuk mengelola data penggajian karyawan secara terstruktur dan efisien. Aplikasi ini dibangun menggunakan teknologi Java Swing dengan arsitektur Multiple Document Interface (MDI) dan menggunakan basis data MySQL untuk penyimpanan data. Kehadiran aplikasi ini bertujuan untuk menjadi solusi atas permasalahan pengelolaan data karyawan, data jabatan, dan transaksi penggajian yang sering kali dilakukan secara manual atau menggunakan spreadsheet yang rentan terhadap kesalahan input dan kehilangan data.

Pengelolaan data gaji secara manual memiliki sejumlah kelemahan, antara lain: (1) memerlukan waktu yang lama untuk mencari dan memperbarui data karyawan, (2) risiko kesalahan perhitungan yang tinggi, (3) kesulitan dalam menghasilkan laporan yang akurat dan cepat, serta (4) tidak adanya sistem keamanan yang memadai untuk melindungi data sensitif karyawan. Penelitian menunjukkan bahwa sistem informasi penggajian yang terkomputerisasi dapat meningkatkan efisiensi operasional hingga 40% dan mengurangi kesalahan administratif secara signifikan (Johnson & Smith, 2020).

Aplikasi Gaji Karyawan PT Sintory menyediakan fitur-fitur utama yang mencakup:

1. **Manajemen Data Karyawan** – Mengelola informasi identitas karyawan termasuk nomor KTP, nama, ruang kerja, dan kredensial login yang terenkripsi menggunakan algoritma MD5 untuk keamanan.

2. **Manajemen Data Pekerjaan** – Mengelola jenis-jenis pekerjaan atau jabatan yang tersedia di perusahaan beserta jumlah tugas yang menjadi tanggung jawab setiap posisi.

3. **Transaksi Penggajian** – Mencatat dan mengelola data gaji karyawan berdasarkan jabatan yang dipegang, termasuk gaji bersih, gaji kotor, dan tunjangan. Satu karyawan dapat memiliki beberapa entri gaji sesuai dengan jabatan yang diemban.

4. **Sistem Login dan Kontrol Akses** – Mengamankan akses ke dalam sistem dengan autentikasi berbasis KTP dan password terenkripsi. Menu-menu utama hanya dapat diakses setelah pengguna berhasil login.

5. **Pelaporan Terintegrasi** – Menghasilkan laporan yang dapat dicetak dalam format profesional menggunakan JasperReports, meliputi laporan data gaji, data karyawan, dan data pekerjaan.

Aplikasi ini dirancang dengan antarmuka yang intuitif dan mengikuti prinsip desain Multiple Document Interface (MDI), di mana semua form data entry dibuka sebagai jendela internal (JInternalFrame) di dalam jendela utama (JFrame). Hal ini memungkinkan pengguna untuk membuka dan mengelola beberapa form sekaligus tanpa harus membuka banyak jendela aplikasi terpisah.

Dengan pendekatan ini, Aplikasi Gaji Karyawan PT Sintory memfasilitasi staf administrasi dan manajemen perusahaan untuk mengelola data penggajian secara lebih cepat, akurat, dan aman, sehingga mendukung peningkatan kualitas operasional dan efisiensi kerja secara keseluruhan.

1

## **RANCANGAN LAYAR DAN PENGGUNAAN**

## **1.1. Login**

_Gambar 1.1.1 Tampilan Form Login_

**==> picture [800 x 500] intentionally omitted <==**

Form Login adalah halaman pertama yang akan muncul ketika aplikasi dijalankan. Form ini berfungsi sebagai gerbang keamanan untuk mengakses sistem. Pengguna harus memasukkan kredensial yang valid untuk dapat menggunakan fitur-fitur aplikasi. Form Login memiliki komponen sebagai berikut:

a. **User ID (KTP)** : Field input untuk memasukkan nomor KTP karyawan yang telah terdaftar dalam sistem. Nomor KTP berfungsi sebagai identitas unik setiap pengguna.

b. **Password** : Field input untuk memasukkan kata sandi yang telah dienkripsi menggunakan algoritma MD5. Password tidak ditampilkan dalam bentuk teks biasa (menggunakan karakter mask) untuk keamanan.

c. **Tombol Login** : Tombol untuk melakukan proses autentikasi. Sistem akan memverifikasi kombinasi User ID dan Password dengan data yang tersimpan di database. Jika valid, pengguna akan diberikan akses ke halaman utama dan semua menu akan diaktifkan.

d. **Tombol Batal** : Tombol untuk membatalkan proses login dan menutup aplikasi.

**Mekanisme Keamanan:**

Sistem menggunakan algoritma hashing MD5 untuk menyimpan password. Ketika pengguna memasukkan password, sistem akan meng-hash input tersebut dan membandingkannya dengan hash yang tersimpan di database. Jika cocok, login berhasil. Jika tidak, sistem akan menampilkan pesan error dan pengguna harus mencoba kembali.

Setelah login berhasil, menu-menu **Master Data**, **Transaksi**, dan **Laporan** yang sebelumnya dalam kondisi nonaktif (disabled) akan diaktifkan. Menu **Login** pada menu bar akan berubah menjadi **Logout**.

2

3

## **1.2. Halaman Utama**

_Gambar 1.2.1 Tampilan Halaman Utama (Menu Bar)_

**==> picture [1200 x 700] intentionally omitted <==**

Halaman Utama adalah jendela utama aplikasi yang menggunakan arsitektur Multiple Document Interface (MDI). Halaman ini memiliki area kerja berupa JDesktopPane yang dapat menampung beberapa jendela internal (JInternalFrame) sekaligus. Pengguna dapat membuka form-form data entry secara bersamaan di dalam satu jendela aplikasi.

**Struktur Menu Bar:**

Halaman utama memiliki menu bar dengan empat menu utama:

**1. Menu Aplikasi**
   - **Deskripsi** : Menampilkan informasi tentang aplikasi (fitur ini masih dalam pengembangan)
   - **Login / Logout** : Toggle untuk masuk atau keluar dari sistem. Setelah login, menu ini berubah menjadi Logout
   - **Keluar** : Menutup aplikasi dan mengakhiri program

**2. Menu Master Data**
   - **Karyawan** : Membuka form untuk mengelola data karyawan (tambah, ubah, hapus, cari)
   - **Pekerjaan** : Membuka form untuk mengelola data jabatan/pekerjaan

**3. Menu Transaksi**
   - **Gaji** : Membuka form untuk mengelola transaksi penggajian karyawan

**4. Menu Laporan**
   - **Gaji** : Membuka laporan data gaji dalam format JasperReports
   - **Karyawan** : Membuka laporan data karyawan
   - **Pekerjaan** : Membuka laporan data pekerjaan

**Kontrol Akses:**

Saat aplikasi pertama kali dibuka (sebelum login), hanya menu **Aplikasi** yang aktif. Menu **Master Data**, **Transaksi**, dan **Laporan** dalam kondisi nonaktif (disabled). Setelah pengguna berhasil login, semua menu akan diaktifkan dan pengguna dapat mengakses seluruh fitur aplikasi.

**Fitur MDI:**

Aplikasi menggunakan pola MDI sehingga pengguna dapat membuka beberapa form sekaligus. Jika pengguna mencoba membuka form yang sudah terbuka, sistem akan membawa form tersebut ke depan (toFront) tanpa membuat duplikat jendela.

4

## **1.3. Master Data Karyawan**

## **1.3.1. Form Data Karyawan**

_Gambar 1.3.1 Tampilan Form Data Karyawan_

**==> picture [800 x 600] intentionally omitted <==**

Form Data Karyawan dapat diakses melalui menu **Master Data > Karyawan**. Form ini berfungsi untuk mengelola data karyawan perusahaan dengan operasi Create, Read, Update, dan Delete (CRUD). Form ini dibuka sebagai JInternalFrame di dalam halaman utama. Komponen-komponen pada form ini meliputi:

**Field Input:**

a. **KTP** : Field input untuk nomor KTP karyawan (maksimal 15 karakter). Nomor KTP berfungsi sebagai primary key dan identitas unik karyawan. Field ini mendukung pencarian otomatis dengan menekan tombol **Enter**.

b. **Nama** : Field input untuk nama lengkap karyawan (maksimal 30 karakter).

c. **Ruang** : ComboBox untuk memilih ruang kerja karyawan. Pilihan tersedia dari Ruang 1 hingga Ruang 14.

d. **Password** : Field input untuk password login karyawan. Password akan dienkripsi menggunakan MD5 sebelum disimpan ke database. Field ini menggunakan karakter mask untuk keamanan.

**Tombol Aksi:**

a. **Simpan** : Menyimpan data karyawan baru atau memperbarui data karyawan yang sudah ada. Sistem akan melakukan validasi input sebelum menyimpan. Password akan di-hash menggunakan MD5 sebelum disimpan ke database.

b. **Hapus** : Menghapus data karyawan yang sedang ditampilkan. Sistem akan menampilkan dialog konfirmasi sebelum melakukan penghapusan untuk mencegah penghapusan data secara tidak sengaja.

c. **Lihat** : Membuka dialog yang menampilkan daftar seluruh karyawan dalam bentuk tabel. Pengguna dapat memilih salah satu karyawan dari daftar, dan data karyawan tersebut akan otomatis dimuat ke dalam form.

d. **Tutup** : Menutup form Data Karyawan.

**Fitur Pencarian Cepat:**

Pengguna dapat melakukan pencarian data karyawan dengan memasukkan nomor KTP pada field KTP, kemudian menekan tombol **Enter**. Sistem akan mencari data karyawan dengan nomor KTP tersebut dan menampilkan informasinya di form. Jika data tidak ditemukan, field-field akan kosong dan pengguna dapat memasukkan data karyawan baru.

5

## **1.3.2. Dialog Lihat Karyawan**

_Gambar 1.3.2 Tampilan Dialog Lihat Karyawan_

**==> picture [700 x 500] intentionally omitted <==**

Dialog Lihat Karyawan adalah jendela modal yang menampilkan daftar seluruh karyawan yang terdaftar dalam sistem. Dialog ini dapat diakses dengan menekan tombol **Lihat** pada Form Data Karyawan. Dialog ini memiliki komponen sebagai berikut:

a. **Tabel Data Karyawan** : Menampilkan daftar karyawan dalam bentuk tabel dengan kolom:
   - **KTP** : Nomor KTP karyawan
   - **Nama** : Nama lengkap karyawan

b. **Tombol Pilih** : Setelah pengguna memilih salah satu baris pada tabel, tombol ini akan memuat data karyawan tersebut ke Form Data Karyawan dan menutup dialog.

c. **Tombol Batal** : Menutup dialog tanpa memilih data.

**Cara Penggunaan:**

1. Klik salah satu baris pada tabel untuk memilih karyawan
2. Klik tombol **Pilih** untuk memuat data karyawan tersebut ke form
3. Dialog akan tertutup dan data karyawan akan ditampilkan di Form Data Karyawan

Dialog ini sangat berguna ketika pengguna tidak mengingat nomor KTP karyawan yang ingin dicari atau diubah datanya.

6

## **1.4. Master Data Pekerjaan**

## **1.4.1. Form Data Pekerjaan**

_Gambar 1.4.1 Tampilan Form Data Pekerjaan_

**==> picture [800 x 600] intentionally omitted <==**

Form Data Pekerjaan dapat diakses melalui menu **Master Data > Pekerjaan**. Form ini berfungsi untuk mengelola data jabatan atau jenis pekerjaan yang tersedia di perusahaan. Form ini dibuka sebagai JInternalFrame di dalam halaman utama. Komponen-komponen pada form ini meliputi:

**Field Input:**

a. **Kode Pekerjaan** : Field input untuk kode unik pekerjaan (maksimal 15 karakter). Kode ini berfungsi sebagai primary key. Field ini mendukung pencarian otomatis dengan menekan tombol **Enter**.

b. **Nama Pekerjaan** : Field input untuk nama lengkap jabatan atau pekerjaan (maksimal 50 karakter).

c. **Jumlah Tugas** : ComboBox untuk memilih jumlah tugas yang menjadi tanggung jawab posisi ini. Pilihan yang tersedia: 1, 2, 3, 4, dan 6 tugas.

**Tombol Aksi:**

a. **Simpan** : Menyimpan data pekerjaan baru atau memperbarui data pekerjaan yang sudah ada. Sistem akan melakukan validasi input sebelum menyimpan.

b. **Hapus** : Menghapus data pekerjaan yang sedang ditampilkan. Sistem akan menampilkan dialog konfirmasi sebelum melakukan penghapusan.

c. **Lihat** : Membuka dialog yang menampilkan daftar seluruh pekerjaan dalam bentuk tabel. Pengguna dapat memilih salah satu pekerjaan dari daftar, dan data pekerjaan tersebut akan otomatis dimuat ke dalam form.

d. **Tutup** : Menutup form Data Pekerjaan.

**Fitur Pencarian Cepat:**

Sama seperti Form Data Karyawan, pengguna dapat melakukan pencarian data pekerjaan dengan memasukkan kode pekerjaan pada field Kode Pekerjaan, kemudian menekan tombol **Enter**. Sistem akan mencari data pekerjaan dengan kode tersebut dan menampilkan informasinya di form.

7

## **1.4.2. Dialog Lihat Pekerjaan**

_Gambar 1.4.2 Tampilan Dialog Lihat Pekerjaan_

**==> picture [700 x 500] intentionally omitted <==**

Dialog Lihat Pekerjaan adalah jendela modal yang menampilkan daftar seluruh jenis pekerjaan yang terdaftar dalam sistem. Dialog ini dapat diakses dengan menekan tombol **Lihat** pada Form Data Pekerjaan. Dialog ini memiliki komponen sebagai berikut:

a. **Tabel Data Pekerjaan** : Menampilkan daftar pekerjaan dalam bentuk tabel dengan kolom:
   - **Kode Pekerjaan** : Kode unik pekerjaan
   - **Nama Pekerjaan** : Nama lengkap jabatan/pekerjaan

b. **Tombol Pilih** : Setelah pengguna memilih salah satu baris pada tabel, tombol ini akan memuat data pekerjaan tersebut ke Form Data Pekerjaan dan menutup dialog.

c. **Tombol Batal** : Menutup dialog tanpa memilih data.

**Cara Penggunaan:**

1. Klik salah satu baris pada tabel untuk memilih pekerjaan
2. Klik tombol **Pilih** untuk memuat data pekerjaan tersebut ke form
3. Dialog akan tertutup dan data pekerjaan akan ditampilkan di Form Data Pekerjaan

8

## **1.5. Transaksi Gaji**

_Gambar 1.5.1 Tampilan Form Transaksi Gaji_

**==> picture [1000 x 700] intentionally omitted <==**

Form Transaksi Gaji dapat diakses melalui menu **Transaksi > Gaji**. Form ini merupakan form yang paling kompleks dalam aplikasi karena menggabungkan data karyawan dan data pekerjaan untuk membentuk transaksi penggajian. Satu karyawan dapat memiliki beberapa entri gaji sesuai dengan jabatan yang diemban. Form ini dibagi menjadi dua bagian utama:

**Bagian Atas - Informasi Karyawan:**

a. **KTP** : Field input untuk nomor KTP karyawan. Field ini mendukung pencarian otomatis dengan menekan tombol **Enter**. Ketika data karyawan ditemukan, informasi karyawan dan data gaji yang sudah ada akan otomatis dimuat.

b. **Tombol Lihat** : Membuka dialog Lihat Karyawan untuk memilih karyawan dari daftar.

c. **Nama** : Field read-only yang menampilkan nama karyawan yang dipilih.

d. **Ruang** : Field read-only yang menampilkan ruang kerja karyawan yang dipilih.

**Bagian Bawah - Tabel Data Gaji:**

Tabel ini menampilkan daftar gaji karyawan berdasarkan jabatan yang dipegang. Tabel memiliki kolom sebagai berikut:

a. **Kode** : Kode pekerjaan. Field ini dapat diedit langsung di dalam tabel. Setelah memasukkan kode dan menekan **Enter**, sistem akan otomatis mengisi kolom Nama Pekerjaan.

b. **Nama Pekerjaan** : Nama jabatan/pekerjaan. Field ini akan terisi otomatis setelah kode pekerjaan valid dimasukkan.

c. **Gaji Bersih** : Jumlah gaji bersih yang diterima karyawan untuk jabatan ini (dalam Rupiah).

d. **Gaji Kotor** : Jumlah gaji kotor sebelum potongan (dalam Rupiah).

e. **Tunjangan** : Jumlah tunjangan yang diterima untuk jabatan ini (dalam Rupiah).

9

_Gambar 1.5.2 Tampilan Menu Popup Tabel Gaji_

**==> picture [600 x 400] intentionally omitted <==**

**Menu Popup Tabel:**

Pengguna dapat mengklik kanan pada tabel untuk menampilkan menu popup dengan pilihan:

a. **Tambah Item** : Membuka dialog Lihat Pekerjaan untuk memilih pekerjaan yang akan ditambahkan ke tabel. Setelah memilih, baris baru akan ditambahkan dengan kode dan nama pekerjaan yang dipilih.

b. **Hapus Item** : Menghapus baris yang sedang dipilih dari tabel.

**Tombol Aksi:**

a. **Simpan** : Menyimpan semua data gaji pada tabel untuk karyawan yang dipilih. Sistem akan menghapus semua data gaji lama karyawan tersebut, kemudian menyimpan ulang semua data yang ada di tabel.

b. **Tutup** : Menutup form Transaksi Gaji.

**Cara Penggunaan:**

1. Masukkan nomor KTP karyawan atau klik tombol **Lihat** untuk memilih dari daftar
2. Data karyawan dan gaji yang sudah ada (jika ada) akan dimuat ke form
3. Untuk menambah jabatan baru: klik kanan pada tabel > **Tambah Item** > pilih pekerjaan
4. Isi nilai Gaji Bersih, Gaji Kotor, dan Tunjangan untuk setiap baris
5. Untuk menghapus baris: pilih baris > klik kanan > **Hapus Item**
6. Klik **Simpan** untuk menyimpan semua perubahan

**Navigasi Tabel:**

Pengguna dapat menekan tombol **Enter** untuk berpindah antar sel dalam tabel. Ketika memasukkan kode pekerjaan pada kolom Kode dan menekan Enter, sistem akan otomatis mengisi kolom Nama Pekerjaan jika kode valid.

10

## **1.6. Laporan**

Aplikasi menyediakan tiga jenis laporan yang dapat dicetak menggunakan teknologi JasperReports. Semua laporan ditampilkan dalam jendela JasperViewer yang memungkinkan pengguna untuk melihat pratinjau, mencetak, atau mengekspor laporan ke berbagai format (PDF, Excel, dll).

## **1.6.1. Laporan Gaji**

_Gambar 1.6.1 Tampilan Laporan Gaji_

**==> picture [1200 x 800] intentionally omitted <==**

Laporan Gaji dapat diakses melalui menu **Laporan > Gaji**. Laporan ini menampilkan data lengkap penggajian seluruh karyawan dengan detail sebagai berikut:

**Kolom-kolom Laporan:**

a. **KTP** : Nomor KTP karyawan
b. **Nama** : Nama lengkap karyawan
c. **Ruang** : Ruang kerja karyawan
d. **Kode Pekerjaan** : Kode jabatan yang dipegang
e. **Nama Pekerjaan** : Nama lengkap jabatan
f. **Jumlah Tugas** : Jumlah tugas yang menjadi tanggung jawab jabatan
g. **Gaji Bersih** : Gaji bersih yang diterima
h. **Gaji Kotor** : Gaji kotor sebelum potongan
i. **Tunjangan** : Tunjangan yang diterima
j. **Gaji Pokok** : Dihitung otomatis dengan rumus: (Gaji Bersih + Gaji Kotor + Tunjangan) / 3, dibulatkan 2 desimal
k. **Grade** : Klasifikasi gaji berdasarkan rata-rata:
   - **Grade A** : Gaji Pokok >= Rp 5.000.000
   - **Grade B** : Gaji Pokok >= Rp 4.000.000
   - **Grade C** : Gaji Pokok >= Rp 3.000.000
   - **Grade D** : Gaji Pokok >= Rp 2.000.000
   - **Grade E** : Gaji Pokok < Rp 2.000.000
l. **Status UMR** : Status apakah gaji memenuhi standar UMR (>= Rp 1.000.000)

Laporan ini menggunakan query SQL kompleks yang menggabungkan tiga tabel (tbkaryawan, tbpekerjaan, tbgaji) dan melakukan perhitungan otomatis untuk kolom Grade dan Status UMR.

11

## **1.6.2. Laporan Karyawan**

_Gambar 1.6.2 Tampilan Laporan Karyawan_

**==> picture [1000 x 700] intentionally omitted <==**

Laporan Karyawan dapat diakses melalui menu **Laporan > Karyawan**. Laporan ini menampilkan daftar seluruh karyawan yang terdaftar dalam sistem dengan kolom:

a. **KTP** : Nomor KTP karyawan
b. **Nama** : Nama lengkap karyawan
c. **Ruang** : Ruang kerja karyawan (1-14)

Laporan ini berguna untuk mendapatkan overview seluruh data karyawan yang terdaftar dalam sistem.

## **1.6.3. Laporan Pekerjaan**

_Gambar 1.6.3 Tampilan Laporan Pekerjaan_

**==> picture [1000 x 700] intentionally omitted <==**

Laporan Pekerjaan dapat diakses melalui menu **Laporan > Pekerjaan**. Laporan ini menampilkan daftar seluruh jenis pekerjaan yang tersedia di perusahaan dengan kolom:

a. **Kode Pekerjaan** : Kode unik pekerjaan
b. **Nama Pekerjaan** : Nama lengkap jabatan/pekerjaan
c. **Jumlah Tugas** : Jumlah tugas yang menjadi tanggung jawab posisi ini

Laporan ini berguna untuk melihat struktur jabatan yang ada di perusahaan beserta beban kerja (jumlah tugas) masing-masing posisi.

12

## **STRUKTUR BERKAS**

Struktur berkas pada proyek Aplikasi Gaji Karyawan PT Sintory disusun secara sistematis mengikuti standar project Java dengan NetBeans IDE. Setiap komponen aplikasi (model, view, controller, dan report) ditempatkan dalam package yang sesuai dengan fungsinya, sehingga alur integrasi antar komponen menjadi lebih jelas dan terorganisir. Adapun rincian jalur (path) dan susunan berkas pada proyek ini sebagai berikut:

`
Project Java Verrel Kelas/
+-- nbproject/               (konfigurasi project NetBeans)
+-- build/                   (hasil kompilasi)
+-- dist/                    (distribusi aplikasi JAR)
+-- MySQL Database/
    +-- projectjavaverreldatabase.sql    (schema database)
+-- src/
    +-- aplikasigajikaryawanptsintory/
        +-- AplikasiGajiKaryawanPTSintory.java (entry point)
    +-- model/
        +-- Koneksi.java                (koneksi database MySQL)
        +-- Karyawan.java               (entity + CRUD karyawan)
        +-- Pekerjaan.java              (entity + CRUD pekerjaan)
        +-- Gaji.java                   (entity + CRUD gaji + report)
        +-- Enkripsi.java               (utility MD5 hashing)
    +-- id/verrel/
        +-- pertemuan1/                 (main frame + report forms)
            +-- FormUtama.java/.form    (MDI main window)
            +-- FormDeskripsi.java      (about dialog stub)
            +-- FormCetakGaji.java/.form        (print salary report)
            +-- FormCetakKaryawan.java/.form    (print employee report)
            +-- FormCetakPekerjaan.java/.form   (print job report)
        +-- pertemuan2/                 (employee UI)
            +-- FormKaryawan.java/.form         (employee form)
            +-- FormLihatKaryawan.java/.form    (employee list dialog)
        +-- pertemuan3/                 (job UI + utility)
            +-- FormPekerjaan.java/.form        (job form)
            +-- FormLihatPekerjaan.java/.form   (job list dialog)
            +-- PesanDialog.java                (JOptionPane wrapper)
        +-- pertemuan4/                 (salary UI)
            +-- FormGaji.java/.form             (salary management form)
            +-- KeyEvent.java                   (constant holder)
        +-- pertemuan5/                 (controllers MVC)
            +-- KaryawanController.java
            +-- PekerjaanController.java
            +-- GajiController.java
            +-- LoginController.java
        +-- pertemuan6/                 (login UI)
            +-- FormLogin.java/.form            (login dialog)
    +-- ireportaplikasi/                (JasperReports templates)
        +-- reportGaji.jrxml/.jasper            (salary report template)
        +-- reportKaryawan.jrxml/.jasper        (employee report template)
        +-- reportPekerjaan.jrxml/.jasper       (job report template)
        +-- cherry.jpg                          (report logo/image)
+-- build.xml                (ant build script)
+-- manifest.mf              (JAR manifest)
+-- README.md                (dokumentasi singkat)
`

_Gambar 2.1 Struktur Berkas Proyek_

**Penjelasan Struktur:**

- **model/** : Berisi kelas-kelas untuk akses database dan business logic
- **id.verrel.pertemuan1-6/** : Package UI yang diorganisir berdasarkan sesi pertemuan pengembangan
- **ireportaplikasi/** : Template JasperReports untuk laporan
- **MySQL Database/** : File SQL untuk membuat database dan tabel

13

## **TATA CARA PENGGUNAAN SISTEM**

Berikut adalah panduan langkah demi langkah untuk menggunakan Aplikasi Gaji Karyawan PT Sintory:

**1. Persiapan Awal:**

a. Pastikan database MySQL sudah terinstal dan berjalan di localhost:3305
b. Import file projectjavaverreldatabase.sql dari folder MySQL Database/ ke dalam MySQL server
c. Pastikan database bernama dbaplikasigajikaryawan sudah terbuat dengan 3 tabel: 	bkaryawan, 	bpekerjaan, dan 	bgaji
d. Pastikan library yang dibutuhkan sudah tersedia: JasperReports 6.21.5+, Commons Collections 4-4.5.0+, MySQL Connector/J 9.3.0+

**2. Menjalankan Aplikasi:**

a. Jalankan aplikasi melalui NetBeans atau file JAR yang ada di folder dist/
b. Form Login akan muncul pertama kali
c. Masukkan User ID (KTP) dan Password karyawan yang sudah terdaftar
d. Klik tombol **Login** untuk masuk ke sistem

**3. Mengelola Data Karyawan:**

a. Pilih menu **Master Data > Karyawan**
b. Untuk menambah karyawan baru: isi semua field (KTP, Nama, Ruang, Password) > klik **Simpan**
c. Untuk mencari karyawan: masukkan nomor KTP > tekan **Enter**, atau klik **Lihat** untuk memilih dari daftar
d. Untuk mengubah data: cari karyawan > ubah field yang diperlukan > klik **Simpan**
e. Untuk menghapus: cari karyawan > klik **Hapus** > konfirmasi penghapusan

**4. Mengelola Data Pekerjaan:**

a. Pilih menu **Master Data > Pekerjaan**
b. Untuk menambah pekerjaan baru: isi semua field (Kode, Nama, Jumlah Tugas) > klik **Simpan**
c. Untuk mencari pekerjaan: masukkan kode > tekan **Enter**, atau klik **Lihat** untuk memilih dari daftar
d. Untuk mengubah/menghapus: sama seperti cara mengelola data karyawan

**5. Mengelola Transaksi Gaji:**

a. Pilih menu **Transaksi > Gaji**
b. Cari karyawan dengan memasukkan KTP atau klik **Lihat**
c. Untuk menambah jabatan baru: klik kanan pada tabel > **Tambah Item** > pilih pekerjaan
d. Isi nilai Gaji Bersih, Gaji Kotor, dan Tunjangan untuk setiap baris
e. Untuk menghapus baris: pilih baris > klik kanan > **Hapus Item**
f. Klik **Simpan** untuk menyimpan semua perubahan

**6. Mencetak Laporan:**

a. Pilih menu **Laporan** > pilih jenis laporan yang diinginkan (Gaji/Karyawan/Pekerjaan)
b. Sistem akan menampilkan laporan di JasperViewer
c. Gunakan toolbar JasperViewer untuk mencetak, mengekspor, atau melihat pratinjau

**7. Logout:**

a. Pilih menu **Aplikasi > Logout** untuk keluar dari sistem
b. Menu-menu akan dinonaktifkan kembali
c. Untuk mengakses kembali, harus login ulang

14

## **DAFTAR PUSTAKA**

- Johnson, M., & Smith, R. (2020). _The Impact of Computerized Payroll Systems on Organizational Efficiency_. Journal of Information Systems Management, 15(3), 245-267.

- Oracle Corporation. (2024). _Java Swing Documentation_. Retrieved from https://docs.oracle.com/javase/tutorial/uiswing/

- TIBCO Jaspersoft. (2024). _JasperReports Library Documentation_. Retrieved from https://community.jaspersoft.com/documentation

- Oracle Corporation. (2024). _MySQL Connector/J Developer Guide_. Retrieved from https://dev.mysql.com/doc/connector-j/en/

15

