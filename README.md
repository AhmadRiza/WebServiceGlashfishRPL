# WebServiceGlashfishRPL

### Reques[GET]
http://localhost:8080/api/resources/cur_harga

```
[{
	"kode": "DAY",
	"nama": "Daging Ayam",
	"tgl": "2018-05-21 09:08:49.0",
	"satuan": "kg",
	"harga": 20000.0
}, {
	"kode": "TMP",
	"nama": "Tempe",
	"tgl": "2018-05-21 09:05:25.0",
	"satuan": "kg",
	"harga": 10000.0
}, {
	"kode": "THU",
	"nama": "Tahu",
	"tgl": "2018-05-21 09:05:13.0", 
	"satuan": "kg",
	"harga": 10000.0
}, {
	"kode": "CBE",
	"nama": "Cabe",
	"tgl": "2018-05-21 09:04:27.0",
	"satuan": "kg",
	"harga": 25000.0
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

