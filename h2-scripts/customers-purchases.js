let customers_purchases = [
	{
		"nome": "Geraldo Pedro Julio Nascimento",
		"cpf": "05870189179",
		"compras":[
			{
				"codigo": "1",
				"quantidade": 6
			},
			{
				"codigo": "15",
				"quantidade": 4
			},
			{
				"codigo": "10",
				"quantidade": 2
			},
			{
				"codigo": "5",
				"quantidade": 3
			},
			{
				"codigo": "2",
				"quantidade": 5
			}
		]
	},
	{
		"nome": "Vitória Alícia Mendes",
		"cpf": "20623850567",
		"compras": [
			{
			  "codigo": "1",
			  "quantidade": 8
			}
		]
	},
	{
		"nome": "Teresinha Daniela Galvão",
		"cpf": "04372012950",
		"compras": [
			{
			  "codigo": "14",
			  "quantidade": 3
			},
			{
			  "codigo": "20",
			  "quantidade": 3
			},
			{
			  "codigo": "4",
			  "quantidade": 2
			}
		]
	},
	{
		"nome": "Gabriel Rafael Dias",
		"cpf": "85067950013",
		"compras":[
			{
				"codigo": "17",
				"quantidade": 6
			},
			{
				"codigo": "19",
				"quantidade": 4
			}
		]
	},
	{
		"nome": "Andreia Emanuelly da Mata",
		"cpf": "27737287426",
		"compras":[
			{
				"codigo": "5",
				"quantidade": 6
			},
			{
				"codigo": "4",
				"quantidade": 4
			},
			{
				"codigo": "3",
				"quantidade": 2
			},
			{
				"codigo": "17",
				"quantidade": 3
			},
			{
				"codigo": "13",
				"quantidade": 5
			},
			{
				"codigo": "14",
				"quantidade": 5
			}
		]
	},
	{
		"nome": "Natália Sandra da Cruz",
		"cpf": "03763001590",
		"compras":[
			{
				"codigo": "6",
				"quantidade": 6
			},
			{
				"codigo": "4",
				"quantidade": 4
			}
		]
	},
	{
		"nome": "Catarina Sebastiana Analu Almeida",
		"cpf": "88901767767",
		"compras":[
			{
				"codigo": "16",
				"quantidade": 6
			},
			{
				"codigo": "2",
				"quantidade": 4
			}
		]
	},
	{
		"nome": "Hadassa Daniela Sales",
		"cpf": "1051252612",
		"compras": [
			{
			  "codigo": "19",
			  "quantidade": 3
			},
			{
			  "codigo": "17",
			  "quantidade": 3
			},
			{
			  "codigo": "12",
			  "quantidade": 2
			}
		]
	},
	{
		"nome": "Kaique Danilo Alves",
		"cpf": "20634031392",
		"compras": [
			{
			  "codigo": "8",
			  "quantidade": 3
			}
		]
	},
	{
		"nome": "Pietra Antônia Brenda Silva",
		"cpf": "74302668512",
		"compras": [
			{
			  "codigo": "3",
			  "quantidade": 3
			}
		]
	},
	{
		"nome": "Maitê Kamilly Corte Real",
		"cpf": "022484638124",
		"compras":[
			{
				"codigo": "19",
				"quantidade": 6
			},
			{
				"codigo": "15",
				"quantidade": 4
			}
		]
	},
	{
		"nome": "Isis Isis Ramos",
		"cpf": "29457224965",
		"compras":[
			{
				"codigo": "18",
				"quantidade": 6
			},
			{
				"codigo": "1",
				"quantidade": 4
			}
		]
	},
	{
		"nome": "Fabiana Melissa Nunes",
		"cpf": "824643755772",
		"compras":[
			{
				"codigo": "18",
				"quantidade": 2
			},
			{
				"codigo": "10",
				"quantidade": 10
			}
		]
	},
	{
		"nome": "Ian Joaquim Giovanni Santos",
		"cpf": "96718391344",
		"compras":[
			{
				"codigo": "15",
				"quantidade": 6
			},
			{
				"codigo": "14",
				"quantidade": 4
			},
			{
				"codigo": "3",
				"quantidade": 20
			},
			{
				"codigo": "17",
				"quantidade": 13
			},
			{
				"codigo": "2",
				"quantidade": 15
			}
		]
	}
]

let sql = customers_purchases.map((item,index) => `(${++index}, '${item.cpf}', '${item.nome}')`)

let query = "INSERT INTO CUSTOMER (ID, CPF, NAME) VALUES " + sql +";"
console.log("\n")
console.log(query)

console.log("\n===================================================================================================\n")


let values = []
let id = 1
for(let [indexCustomer, pur] of customers_purchases.entries()){
    indexCustomer = ++indexCustomer
    for(let [indexCompras, compr] of pur.compras.entries()){
        values.push(`(${id}, '${compr.codigo}', ${compr.quantidade}, ${indexCustomer})` )
        id++
    }
    
}

query = "INSERT INTO PURCHASE (ID, CODE, QUANTITY, CUSTOMER_ID) VALUES " + values +";"

console.log(query)
