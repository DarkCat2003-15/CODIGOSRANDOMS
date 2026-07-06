CREATE DATABASE TiendaDB ;
GO

USE TiendaDB;
GO


CREATE TABLE Cliente (
ClienteID int IDENTITY(1,1) primary key not null,
Nombre VARCHAR (100) NOT NULL,
Correo VARCHAR(100) UNIQUE NOT NULL,
FechaRegistro DATE DEFAULT GETDATE(),
Activo BIT DEFAULT 1
);

CREATE TABLE Producto(
ProductoID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
Nombre VARCHAR(200) NOT NULL,
Precio DECIMAL (10,2) CHECK (Precio>= 0),
Stock int default 0,
ClienteID INT,

CONSTRAINT FK_Producto_Cliente
FOREIGN KEY (ClienteID)
REFERENCES Cliente(ClienteID)
);


INSERT INTO Cliente (Nombre, Correo, Activo)
VALUES
('Carlos Ponce', 'Ponce@outlook.com', 0),
('Juan Buenaño', 'juan@gmail.com', 1),
('Ivan Murillo', 'IvanM@hotmail.com', 1),
('Luciana Lucero','lucylu@gmail.com',0);

INSERT INTO Producto(Nombre, Precio, Stock, ClienteID)
VALUES
('Iphone 17', 1000.00, 8, 1),
('Camisa', 25.00, 19, 2),
('Airpods',199.99,27,3);


-- DELETE Producto;

SELECT * FROM Cliente 
WHERE Activo = 1
ORDER BY FechaRegistro DESC;


SELECT
    UPPER(Nombre) AS NombreProducto,
    Precio,
    Precio * 1.12 AS PrecioConIVA
FROM Producto
WHERE Precio > 10
AND Stock > 0;


SELECT Cliente.Nombre, Producto.Nombre as NombreProducto ,Producto.Precio
FROM Cliente
INNER JOIN Producto
    ON Cliente.ClienteID = Producto.ClienteID;

SELECT Cliente.ClienteID, Cliente.Nombre, Producto.Nombre as NombreProducto
FROM Cliente
LEFT JOIN Producto
ON Cliente.ClienteID = Producto.ProductoID;



CREATE PROCEDURE sp_BuscarCliente
    @Nombre VARCHAR(100)
AS
BEGIN
    SELECT *
    FROM Cliente
    WHERE Nombre LIKE '%' + @Nombre + '%';
END;
GO


EXEC sp_BuscarCliente @Nombre = 'I';


CREATE PROCEDURE sp_AgregarProducto 
    @Nombre VARCHAR(100),
    @Precio DECIMAL(10,2),
    @Stock INT,
    @ClienteID INT
AS
BEGIN
    IF @Precio < 0
    BEGIN
        PRINT 'Error: El precio no puede ser negativo';
        RETURN;
    END

    INSERT INTO Producto
    (Nombre, Precio, Stock, ClienteID)
    VALUES
    (@Nombre, @Precio, @Stock, @ClienteID);

    PRINT 'Producto insertado correctamente';

END;
GO



EXEC sp_AgregarProducto 'Impresora', 250.00, 7, 3;
