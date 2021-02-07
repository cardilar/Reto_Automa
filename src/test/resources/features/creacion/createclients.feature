#Author: CESAR ARDILA

@Regresion
Feature: Compra de ropa en Your Logo
  Quiero realizar compra de tres articulos

@CasoExitoso2
  Scenario Outline: Realizando registro de cliente realizar compra
    Given Abrir pagina Your Logo con correo <Correo>
    And Realizar registro del cliente Nombre <Nombre> Apellido "<Apellido>" Clave "<Clave>" Dia "<Dia>" Mes "<Mes>" Ano "<Ano>" Direccion "<Direccion>" Ciudad "<Ciudad>" Estado "<Estado>" CodigoPostal "<CodigoPostal>" Telefono "<Telefono>"
    When Realizar compra de tres articulos 
    And Ingresar medio de pago 
    Then Verfico compra exitosa Mensaje "<Mensaje>"   
    
			Examples: 
|Correo|Nombre|Apellido|Clave|Dia|Mes|Ano|Direccion|Ciudad|Estado|CodigoPostal|Telefono|Mensaje|	
##@externaldata@C:\Datos\Data.xlsx@prueba
|jymmie.fox1@hg.com|Jymmie|Fox|jfiw122|28|7|1980|Street 11|Michigan|17|00000|7658908989|Your order on My Store is complete.|
|car.sagam1@hg.com|Geroge|Carlson|csa124|11|12|1985|Main Street 71|Belmont|22|00000|2134123412|Your order on My Store is complete.|
