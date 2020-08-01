# BootCamp SENA para ADSI Fase 2
**Desarrollo del Bootcamp organizado el 1 de Agosto de 2020**

Proyecto desarrollado por *@GKentaurus*, *@Dannychan94* y *Veronica* (que no tiene GitHub aún).

## Caso 2:
El siguiente algoritmo hace uso de procedimientos, funciones y programación orientada a objetos para cargar y mostrar la información de registros así: 

Una de las actividades más comunes en el mundo financiero, es la realización de simulaciones que permitan a los clientes saber el rendimiento de sus productos a través del tiempo, contemplando diferentes escenarios y posibles situaciones que se presenten.
Se quiere crear un programa que haga la simulación de la cuenta bancaria de un cliente. El registro de un cliente está definido por un nombre y un número de cédula el cual identifica la cuenta. Una cuenta, por su parte está constituida por tres productos financieros básicos: (1) una cuenta de ahorro, (2) una cuenta corriente y (3) un certificado de depósito a término CDT. Estos productos son independientes y tienen comportamientos particulares.
 
El saldo total de la cuenta es la suma de lo que el cliente tiene en cada uno de dichos productos. En la cuenta corriente el cliente puede depositar o retirar dinero. Su principal característica es que no recibe ningún interés por el dinero que se encuentre allí depositado. En la cuenta de ahorro, se paga un interés mensual del 0.6% sobre el saldo. Cuando el cliente abre un CDT, define la cantidad de dinero que quiere invertir y negocia con el banco el interés mensual que va a recibir. A diferencia de la cuenta corriente o la cuenta de ahorro, en un CDT no se puede consignar ni retirar dinero. La única operación posible es cerrarlo, en cuyo caso, el dinero y sus intereses pasan a la cuenta corriente.

---
### Requerimientos
Se quiere que el programa permita a una persona simular el manejo de sus productos bancarios, dándole las facilidades de: (1) hacer las operaciones necesarias sobre los productos que conforman la cuenta, para que el cliente pueda ver el resultado de sus movimientos bancarios y el rendimiento de sus inversiones.

Para ello el programa debe contar con un menú que presente las siguientes opciones.
1.	Crear cliente con saldo cero en las cuentas
2.	Consignar en la cuenta corriente
3.	Consignar en la cuenta de ahorros. 
4.	Invertir en un CDT 
5.	Calcular el saldo total de un cliente en el banco
6.	Retirar de la cuenta corriente
7.	Retirar de la cuenta de ahorros
8.	Dar el saldo de la cuenta corriente
9.	Dar el saldo de la cuenta de ahorros
10.	Cerrar el CDT y pasar a la cuenta corriente
11.	Simular el nuevo saldo de una cuenta de ahorros dependiendo de los meses ingresados (se paga un interés mensual del 0.6% sobre el saldo mensual.), sin alterar el saldo actual de la cuenta de ahorros.

---
### Requisitos
Cada opción debe ser implementada con funciones o procedimientos

---
#### R0 - Crear las clases
##### Resumen
- Crear la calse de clientes
    - Id Cliente
    - Nombre
- Crear las clases para la cuenta bancaria
    - Id Cliente
    - Saldo Ahorros
    - Saldo Corriente
    - Saldo CDT
    - Monto de invenrisón CDT
    - Interés pactado CDT
    - Fecha Apertura CDT
    - Meses pactados CDT.
##### Entradas
- Ninguna
##### Resultado
- Clases creadas

---
#### R1 - Crear Cliente
##### Resumen
- Crear un registro con los datos del cliente, incluyento saldos en cero (0) para la cuenta bancaria.
##### Entradas
- Nombre
- Cédula
##### Resultados
- Registro del cliente y la cuenta bancaria creada

---
#### R2 - Consignar en la cuenta corriente
##### Resumen
- Abonar a la cuenta del cliente cierta cantidad de dinero
##### Entradas
- Valor a consignar
##### Resultados
- El saldo de la cuenta se modifica según el valor consignado

---
#### R3 - Consignar en la cuenta de ahorros
##### Resumen
- Abonar a la cuenta del cliente cierta cantidad de dinero
##### Entradas
- Valor a consignar
##### Resultados
- El saldo de la cuenta se modifica según el valor consignado

---
#### R4 - Invertir en un CDT
##### Resumen
- Abre un CDT para el cliente, con un monto, un interés, una fecha y meses pactados
##### Entradas
- Monto de la inversión
- Interés pactado
- Fecha de apertura
- Meses pactados
##### Resultados
- Se crea un CDT para un cliente

---
#### R5 - Calcular y mostrar el saldo total de un cliente del banco
##### Resumen
- Calcula el capital del que dispone un cliente
##### Entradas
- Ninguna
##### Resultados
- Se muestra el saldo del cliente

---
#### R6 - Retirar el dinero de la cuenta de Ahorros
##### Resumen
- Se disminuye el saldo del cliente por el valor del retiro realizado
##### Entrada
- El valor a retirar de la cuenta
##### Resultados
- Se modifica el saldo de la cuenta según el dinero retirado

---
#### R7 - Retirar el dinero de la cuenta de Corriente
##### Resumen
- Se disminuye el saldo del cliente por el valor del retiro realizado
##### Entrada
- El valor a retirar de la cuenta
##### Resultados
- Se modifica el saldo de la cuenta según el dinero retirado

---
#### R8 - Cerrar el CDT y pasar a la cuenta corriente
##### Resumen
- Cerrar el CDT de modo que en los siguientes meses no haya rendimiento alguno proveniente de esta cuenta
- Los rendimientos ganados durante el periodo del CDT  más el monto invertido serán abonados a la cuenta corriente.
##### Entradas
- Los meses pactados grabados al crear el CDT
##### Resultado
- La cantidad de dinero (valor inicial + rendimientos) que será abonada a la cuenta corriente

---
#### R9 - Dar el saldo de la cuenta corriente
##### Resumen
- Retorna el saldo de la cuenta corriente en un momento dado.
##### Entradas
- Ninguna
##### Resultados
- El saldo actual del cliente en la cuenta corriente.

---
#### R10 - Dar el saldo de la cuenta de ahorros
##### Resumen
- Retorna el saldo de la cuenta de ahorros en un momento dado.
##### Entradas
- Ninguna
##### Resultados
- El saldo actual del cliente en la cuenta de ahorros.