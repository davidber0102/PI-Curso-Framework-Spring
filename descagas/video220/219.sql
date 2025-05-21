DELIMITER &&
CREATE PROCEDURE `muestra_clientes`()
BEGIN
	SELECT * FROM tabla_de_clientes  WHERE CIUDAD = 'Ciudad de México';
END&&

CALL muestra_clientes;
SELECT * FROM tabla_de_productos;

DELIMITER &&
CREATE PROCEDURE `actualiza_prod`(n_precio FLOAT, n_art VARCHAR(20))
BEGIN
	UPDATE tabla_de_productos SET PRECIO_DE_LISTA = n_precio WHERE NOMBRE_DEL_PRODUCTO = n_art;
END&&

/*
				transacciones
					las transaciones garantizan en una BBDD las caracteristicas ACID,
                    A - ATOMICIDAD - O TODO O NADA  O ME EJECUTAS TODA LA TRNSACION O SI HAY ALGUN DETALLE NO SE EJECTUA
                    C- CONSISTENCIA - INTEGRIDAD DE LOS DATOS, SI ALGO FALLO ALGUNA TAREA EN REVERCIBLE
                    A - AISLAMIENTO
                    D - DURABILIDAD
*/

USE pruebaspi;
SELECT * FROM clientes;

SELECT * FROM clientes WHERE POBLACIÓN = 'ÁVILA';
SELECT * FROM clientes WHERE EMPRESA = 'LA MODERNA' ;
SELECT * FROM pedidos;

/*
		METADATOS ¿ QUE SON ?
			DATOS QUE DESCRIBEN LA BBDD O ALGUNA DE SUS PARTES
		TRES CALSES DE METADATOS:
			- RELATIVOS A ALA BBDD
				* GESTOR DE BBDD
                * VERSION DEL GESTOR
                * DRIVER DE CONEXION A BBDD
                * VERSIO N DEL RIVER            
            - RELATIVOS A UN CONJUNTO DE RESULTADOS:
				* NOMBRES DE LAS TABLAS
                * NOMBRES DE LOS CAMPOS DE LAS TABLAS
                * TIPOS DE DATOS DE LOS CAMPOS
                * PROPEDADES DE LOS CAMPOS
             - RELATIVOS A PARAMETROS DE SENTENCIAS PREPARADAS
				* 
                
	INTERFAZ CONNECTION
		METODO GETMETADATA
			INTERGAZ DATABASEMETADATA
				METODO GETDATABASEPRODUCTNAME()
                METODO GETDATABASEPRODUCTVERSION()
                METODO GETDRIVERNAME()
                METODO GETDRIVERVERSION()
                METODO GETTABLES()
                METODO GETSTRING()
                METODO GETCOLUMNS()
*/

