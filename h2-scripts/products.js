let products = [
    {
        "codigo": 1,
        "tipo_vinho": "Tinto",
        "preco": 229.99,
        "safra": "2017",
        "ano_compra": 2018
    },
    {
        "codigo": 2,
        "tipo_vinho": "Branco",
        "preco": 126.50,
        "safra": "2018",
        "ano_compra": 2019
    },
    {
        "codigo": 3,
        "tipo_vinho": "Rosé",
        "preco": 121.75,
        "safra": "2019",
        "ano_compra": 2020
    },
    {
        "codigo": 4,
        "tipo_vinho": "Espumante",
        "preco": 134.25,
        "safra": "2020",
        "ano_compra": 2021
    },
    {
        "codigo": 5,
        "tipo_vinho": "Chardonnay",
        "preco": 128.99,
        "safra": "2021",
        "ano_compra": 2022
    },
    {
        "codigo": 6,
        "tipo_vinho": "Tinto",
        "preco": 327.50,
        "safra": "2016",
        "ano_compra": 2017
    },
    {
        "codigo": 7,
        "tipo_vinho": "Branco",
        "preco": 125.25,
        "safra": "2017",
        "ano_compra": 2018
    },
    {
        "codigo": 8,
        "tipo_vinho": "Rosé",
        "preco": 120.99,
        "safra": "2018",
        "ano_compra": 2019
    },
    {
        "codigo": 9,
        "tipo_vinho": "Espumante",
        "preco": 135.50,
        "safra": "2019",
        "ano_compra": 2020
    },
    {
        "codigo": 10,
        "tipo_vinho": "Chardonnay",
        "preco": 130.75,
        "safra": "2020",
        "ano_compra": 2021
    },
    {
        "codigo": 11,
        "tipo_vinho": "Tinto",
        "preco": 128.99,
        "safra": "2017",
        "ano_compra": 2018
    },
    {
        "codigo": 12,
        "tipo_vinho": "Branco",
        "preco": 106.50,
        "safra": "2018",
        "ano_compra": 2019
    },
    {
        "codigo": 13,
        "tipo_vinho": "Rosé",
        "preco": 121.75,
        "safra": "2019",
        "ano_compra": 2020
    },
    {
        "codigo": 14,
        "tipo_vinho": "Espumante",
        "preco": 134.25,
        "safra": "2020",
        "ano_compra": 2021
    },
    {
        "codigo": 15,
        "tipo_vinho": "Chardonnay",
        "preco": 188.99,
        "safra": "2021",
        "ano_compra": 2022
    },
    {
        "codigo": 16,
        "tipo_vinho": "Tinto",
        "preco": 127.50,
        "safra": "2016",
        "ano_compra": 2017
    },
    {
        "codigo": 17,
        "tipo_vinho": "Branco",
        "preco": 125.25,
        "safra": "2017",
        "ano_compra": 2018
    },
    {
        "codigo": 18,
        "tipo_vinho": "Rosé",
        "preco": 120.99,
        "safra": "2018",
        "ano_compra": 2019
    },
    {
        "codigo": 19,
        "tipo_vinho": "Espumante",
        "preco": 135.50,
        "safra": "2019",
        "ano_compra": 2020
    },
    {
        "codigo": 20,
        "tipo_vinho": "Chardonnay",
        "preco": 130.75,
        "safra": "2020",
        "ano_compra": 2021
    }
]

let sql = products.map(item => `(${item.codigo}, '${item.codigo}', '${item.tipo_vinho}', ${item.preco}, '${item.safra}', ${item.ano_compra})`)

const query = "INSERT INTO PRODUCT (ID, CODE, WINE_TYPE, PRICE, HARVEST, PURCHASED_YEAR) VALUES " + sql +";"

console.log(query)