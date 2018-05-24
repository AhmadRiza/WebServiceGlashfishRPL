# WebServiceGlashfishRPL

### Reques[GET]
http://localhost:8080/api/resources/dashboard

```
[{
	"kode": "DAY",
	"nama": "Daging Ayam",
	"jumlah": 100,
	"harga": 75000.0
}, {
	"kode": "kaget",
	"nama": "tidak kaget",
	"jumlah": 180,
	"harga": 1091.0
}, {
	"kode": "TST2",
	"nama": "Test 2",
	"jumlah": 110,
	"harga": 19900.0
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

