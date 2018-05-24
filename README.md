# WebServiceGlashfishRPL

### Reques[GET]
http://localhost:8080/api/resources/dashboard

```
[{
	"kode": "BWP",
	"nama": "Bawang Putih",
	"jumlah": 150,
	"harga": 150000.0
}, {
	"kode": "CAB",
	"nama": "Cabai",
	"jumlah": 100,
	"harga": 50000.0
}, {
	"kode": "DAY",
	"nama": "Daging Ayam",
	"jumlah": 100,
	"harga": 75000.0
}, {
	"kode": "GRN",
	"nama": "Garam",
	"jumlah": 150,
	"harga": 30000.0
}, {
	"kode": "HOK",
	"nama": "Bawang Merah",
	"jumlah": 100,
	"harga": 100000.0
}, {
	"kode": "LSP",
	"nama": "Laos",
	"jumlah": 75,
	"harga": 30000.0
}, {
	"kode": "MTN",
	"nama": "Mentimun",
	"jumlah": 100,
	"harga": 78000.0
}, {
	"kode": "PRT",
	"nama": "Minyak Goreng",
	"jumlah": 20,
	"harga": 50000.0
}, {
	"kode": "ROT",
	"nama": "Tepung",
	"jumlah": 600,
	"harga": 45000.0
}, {
	"kode": "SJK",
	"nama": "Sajiku",
	"jumlah": 100,
	"harga": 30000.0
}, {
	"kode": "SLD",
	"nama": "Selada",
	"jumlah": 140,
	"harga": 65000.0
}, {
	"kode": "TFP",
	"nama": "Ketumbar",
	"jumlah": 70,
	"harga": 80000.0
}, {
	"kode": "UNS",
	"nama": "Merica",
	"jumlah": 100,
	"harga": 70000.0
}]
```

# SPECIFIC DATA
### Req[GET]
http://localhost:8080/api/resources/cur_harga?kode_barang=DAY
```
{
	"kode": "DAY",
	"nama": "Daging Ayam",
	"tgl": "2018-05-21 09:08:49.0",
	"satuan": "kg",
	"harga": 20000.0
}
```

### Req[GET]
http://localhost:8080/api/resources/history_harga?kode_barang=DAY
```
{
	"kode": "DAY",
	"nama": "Daging Ayam",
	"satuan": "kg",
	"harga": [{
		"harga": 12000.0,
		"tgl": "2018-05-21 09:04:27.0"
	}, {
		"harga": 20000.0,
		"tgl": "2018-05-21 09:08:49.0"
	}]
}
```
# INSERT
## INSERT BARANG
[POST] 
http://localhost:8080/api/resources/add_barang

```
form param
kode = string
nama = string
satuan = string
```

Res

```
success
```

## INSERT HARGA
[POST] 
http://localhost:8080/api/resources/add_harga

```
form param
kode = string
harga = string
```

Res

```
success
```

