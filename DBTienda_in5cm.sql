Drop database if exists DBTienda_in5cm;
create database DBTienda_in5cm;
use DBTienda_in5cm;

create table Clientes (
	dpi_cliente int auto_increment not null,
    nombre_cliente varchar (50),
    apellido_cliente varchar (50),
    direccion varchar (100),
    estado int,
    primary key PK_dpi_cliente(dpi_cliente)
);

create table Usuarios (
	codigo_usuario int auto_increment not null,
    username varchar(45),
    contrasena varchar (45),
    email varchar (60),
    rol varchar (45),
    estado int,
    primary key PK_codigo_usuario(codigo_usuario)
);

create table Productos (
	codigo_producto int auto_increment not null,
    nombre_producto varchar (60),
    precio decimal (10,2),
    stock int,
    estado int,
    primary key PK_codigo_producto(codigo_producto)
);

create table Ventas (
	codigo_venta int auto_increment not null,
    fecha_venta date,
    total decimal (10,2),
    estado int,
    clientes_dpi_cliente int,
    usuarios_codigo_usuario int,
    primary key PK_codigo_venta(codigo_venta),
    constraint FK_clientes_dpi_cliente foreign key (clientes_dpi_cliente)
        references Clientes (dpi_cliente) on delete cascade,
	constraint FK_usuarios_codigo_usuario foreign key (usuarios_codigo_usuario)
        references Usuarios (codigo_usuario) on delete cascade
);

create table detalle_venta (
	codigo_detalle_venta int auto_increment not null,
    cantidad int,
    precio_unitario decimal (10,2),
    subtotal decimal (10,2),
    productos_codigo_producto int,
    ventas_codigo_venta int,
    primary key PK_codigo_detalle_venta(codigo_detalle_venta),
    constraint FK_productos_codigo_producto foreign key (productos_codigo_producto)
        references Productos (codigo_producto) on delete cascade,
	constraint FK_ventas_codigo_venta foreign key (ventas_codigo_venta)
        references Ventas (codigo_venta) on delete cascade
);

-- PROCEDIMIENTOS ALMACENADOS

-- Clientes --
-- Create --
Delimiter $$ 
	create procedure sp_clientes_create(
        in p_nombre_cliente varchar (50),
        in p_apellido_cliente varchar (50),
        in p_direccion varchar (100),
        in p_estado int)
    begin 
		insert into Clientes(nombre_cliente, apellido_cliente, direccion, estado)
		values (p_nombre_cliente, p_apellido_cliente, p_direccion, p_estado);
		select last_insert_id() as dpi_cliente;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_clientes_delete(in p_dpi_cliente int )
    begin
		delete from Clientes where dpi_cliente = p_dpi_cliente;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Read -- 
Delimiter $$
	create procedure sp_clientes_read_all()
    begin 
		select * from Clientes order by dpi_cliente;
    end $$
Delimiter ;

-- Read by id --
Delimiter $$
	create procedure sp_clientes_read_by_id(in p_dpi_cliente int)
	begin
		select * from Clientes where dpi_cliente = p_dpi_cliente;
	end $$
Delimiter ;

-- Update -- 
Delimiter $$
	create procedure sp_clientes_update(
		in p_dpi_cliente int,
		in p_nombre_cliente varchar (50),
        in p_apellido_cliente varchar (50),
        in p_direccion varchar (100),
        in p_estado int)
    begin 
		update Clientes
		set nombre_cliente = p_nombre_cliente,
            apellido_cliente = p_apellido_cliente,
            direccion = p_direccion,
            estado = p_estado
		where dpi_cliente = p_dpi_cliente;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Usuarios --
-- Create --
Delimiter $$ 
	create procedure sp_usuarios_create(
        in p_username varchar (45),
        in p_contrasena varchar (45),
        in p_email varchar (60),
        in p_rol varchar (45),
        in p_estado int)
    begin 
		insert into Usuarios (username, contrasena, email, rol, estado)
		values (p_username, p_contrasena, p_email, p_rol, p_estado);
		select last_insert_id() as codigo_usuario;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_usuarios_delete(in p_codigo_usuario int )
    begin
		delete from Usuarios where codigo_usuario = p_codigo_usuario;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Read -- 
Delimiter $$
	create procedure sp_usuarios_read_all()
    begin 
		select * from Usuarios order by codigo_usuario;
    end $$
Delimiter ;

-- Read by id --
Delimiter $$
	create procedure sp_usuarios_read_by_id(in p_codigo_usuario int)
	begin
		select * from Usuarios where codigo_usuario = p_codigo_usuario;
	end $$
Delimiter ;

-- Update -- 
Delimiter $$
	create procedure sp_usuarios_update(
		in p_codigo_usuario int,
		in p_username varchar (45),
        in p_contrasena varchar (45),
        in p_email varchar (60),
        in p_rol varchar (45),
        in p_estado int)
    begin 
		update Usuarios
		set username = p_username,
            contrasena = p_contrasena,
            email = p_email,
            rol = p_rol,
            estado = p_estado
		where codigo_usuario = p_codigo_usuario;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Productos --
-- Create --
Delimiter $$ 
	create procedure sp_productos_create(
        in p_nombre_producto varchar (60),
        in p_precio decimal (10,2),
        in p_stock int,
        in p_estado int)
    begin 
		insert into Productos (nombre_producto, precio, stock, estado)
		values (p_nombre_producto, p_precio, p_stock, p_estado);
		select last_insert_id() as codigo_producto;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_productos_delete(in p_codigo_producto int )
    begin
		delete from Productos where codigo_producto = p_codigo_producto;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Read -- 
Delimiter $$
	create procedure sp_productos_read_all()
    begin 
		select * from Productos order by codigo_producto;
    end $$
Delimiter ;

-- Read by id --
Delimiter $$
	create procedure sp_productos_read_by_id(in p_codigo_producto int)
	begin
		select * from Productos where codigo_producto = p_codigo_producto;
	end $$
Delimiter ;

-- Update -- 
Delimiter $$
	create procedure sp_productos_update(
		in p_codigo_producto int,
		in p_nombre_producto varchar (60),
        in p_precio decimal (10,2),
        in p_stock int,
        in p_estado int)
    begin 
		update Productos
		set nombre_producto = p_nombre_producto,
            precio = p_precio,
            stock = p_stock,
            estado = p_estado
		where codigo_producto = p_codigo_producto;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Ventas --
-- Create --
Delimiter $$ 
	create procedure sp_ventas_create(
        in p_fecha_venta date,
        in p_total decimal (10,2),
        in p_estado int,
        in p_clientes_dpi_cliente int,
        in p_usuarios_codigo_usuario int)
    begin 
		insert into Ventas (fecha_venta, total, estado, clientes_dpi_cliente, usuarios_codigo_usuario)
		values (p_fecha_venta, p_total, p_estado, p_clientes_dpi_cliente, p_usuarios_codigo_usuario);
		select last_insert_id() as codigo_venta;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_ventas_delete(in p_codigo_venta int )
    begin
		delete from Ventas where codigo_venta = p_codigo_venta;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Read -- 
Delimiter $$
	create procedure sp_ventas_read_all()
    begin 
		select * from Ventas order by codigo_venta;
    end $$
Delimiter ;

-- Read by id --
Delimiter $$
	create procedure sp_ventas_read_by_id(in p_codigo_venta int)
	begin
		select * from Ventas where codigo_venta = p_codigo_venta;
	end $$
Delimiter ;

-- Update -- 
Delimiter $$
	create procedure sp_ventas_update(
		in p_codigo_venta int,
		in p_fecha_venta date,
        in p_total decimal (10,2),
        in p_estado int,
        in p_clientes_dpi_cliente int,
        in p_usuarios_codigo_usuario int)
    begin 
		update Ventas
		set fecha_venta = p_fecha_venta,
            total = p_total,
            estado = p_estado,
            clientes_dpi_cliente = p_clientes_dpi_cliente,
            usuarios_codigo_usuario = p_usuarios_codigo_usuario
		where codigo_venta = p_codigo_venta;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- detalle_venta --
-- Create --
Delimiter $$ 
	create procedure sp_detalle_venta_create(
        in p_cantidad int,
        in p_precio_unitario decimal (10,2),
        in p_subtotal decimal (10,2),
        in p_productos_codigo_producto int,
        in p_ventas_codigo_venta int)
    begin 
		insert into detalle_venta (cantidad, precio_unitario, subtotal, productos_codigo_producto, ventas_codigo_venta)
		values (p_cantidad, p_precio_unitario, p_subtotal, p_productos_codigo_producto, p_ventas_codigo_venta);
		select last_insert_id() as codigo_detalle_venta;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_detalle_venta_delete(in p_codigo_detalle_venta int )
    begin
		delete from detalle_venta where codigo_detalle_venta = p_codigo_detalle_venta;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Read -- 
Delimiter $$
	create procedure sp_detalle_venta_read_all()
    begin 
		select * from detalle_venta order by codigo_detalle_venta;
    end $$
Delimiter ;

-- Read by id --
Delimiter $$
	create procedure sp_detalle_venta_read_by_id(in p_codigo_detalle_venta int)
	begin
		select * from detalle_venta where codigo_detalle_venta = p_codigo_detalle_venta;
	end $$
Delimiter ;

-- Update -- 
Delimiter $$
	create procedure sp_detalle_venta_update(
		in p_codigo_detalle_venta int,
		in p_cantidad int,
        in p_precio_unitario decimal (10,2),
        in p_subtotal decimal (10,2),
        in p_productos_codigo_producto int,
        in p_ventas_codigo_venta int)
    begin 
		update detalle_venta
		set cantidad = p_cantidad,
            precio_unitario = p_precio_unitario,
            subtotal = p_subtotal,
            productos_codigo_producto = p_productos_codigo_producto,
            ventas_codigo_venta = p_ventas_codigo_venta
		where codigo_detalle_venta = p_codigo_detalle_venta;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Clientes --
call sp_clientes_create('Juan', 'Pérez', 'Zona 1, Guatemala', 1);
call sp_clientes_create('María', 'López', 'Zona 5, Guatemala', 1);
call sp_clientes_create('Carlos', 'Martínez', 'Zona 10, Guatemala', 1);
call sp_clientes_create('Ana', 'García', 'Zona 3, Mixco', 1);
call sp_clientes_create('Luis', 'Hernández', 'Zona 7, Guatemala', 1);
call sp_clientes_create('Sofía', 'Ramírez', 'Zona 2, Villa Nueva', 1);
call sp_clientes_create('Diego', 'Torres', 'Zona 4, Guatemala', 1);
call sp_clientes_create('Valentina', 'Flores', 'Zona 6, Mixco', 1);
call sp_clientes_create('Roberto', 'Jiménez', 'Zona 8, Guatemala', 1);
call sp_clientes_create('Gabriela', 'Morales', 'Zona 11, Guatemala', 1);

-- Usuarios --
call sp_usuarios_create('e', '1', 'jperez@mail.com', 'admin', 1);
call sp_usuarios_create('mlopez', 'pass1234', 'mlopez@mail.com', 'user', 1);
call sp_usuarios_create('cmartinez', 'pass1234', 'cmartinez@mail.com', 'user', 1);
call sp_usuarios_create('agarcia', 'pass1234', 'agarcia@mail.com', 'user', 1);
call sp_usuarios_create('lhernandez', 'pass1234', 'lhernandez@mail.com', 'admin', 1);
call sp_usuarios_create('sramirez', 'pass1234', 'sramirez@mail.com', 'user', 1);
call sp_usuarios_create('dtorres', 'pass1234', 'dtorres@mail.com', 'user', 1);
call sp_usuarios_create('vflores', 'pass1234', 'vflores@mail.com', 'user', 1);
call sp_usuarios_create('rjimenez', 'pass1234', 'rjimenez@mail.com', 'admin', 1);
call sp_usuarios_create('gmorales', 'pass1234', 'gmorales@mail.com', 'user', 1);

-- Productos --
call sp_productos_create('Laptop HP 15"', 3500.00, 20, 1);
call sp_productos_create('Mouse Inalámbrico', 150.00, 50, 1);
call sp_productos_create('Teclado Mecánico', 450.00, 30, 1);
call sp_productos_create('Monitor 24"', 1800.00, 15, 1);
call sp_productos_create('Auriculares Bluetooth', 350.00, 40, 1);
call sp_productos_create('Disco SSD 1TB', 800.00, 25, 1);
call sp_productos_create('Memoria RAM 16GB', 600.00, 35, 1);
call sp_productos_create('Webcam HD', 280.00, 20, 1);
call sp_productos_create('Impresora Epson', 950.00, 10, 1);
call sp_productos_create('USB Hub 7 puertos', 120.00, 60, 1);

-- Ventas --
call sp_ventas_create('2024-01-05', 3800.00,  1, 1,  1);
call sp_ventas_create('2024-01-10', 2250.00,  1, 2,  2);
call sp_ventas_create('2024-01-15', 1500.00,  1, 3,  3);
call sp_ventas_create('2024-02-01', 1480.00,  1, 4,  4);
call sp_ventas_create('2024-02-10', 1310.00,  1, 5,  5);
call sp_ventas_create('2024-02-20', 3950.00,  1, 6,  6);
call sp_ventas_create('2024-03-05', 2100.00,  1, 7,  7);
call sp_ventas_create('2024-03-15', 1400.00,  1, 8,  8);
call sp_ventas_create('2024-04-01', 980.00,   1, 9,  9);
call sp_ventas_create('2024-04-20', 1430.00,  1, 10, 10);

-- DetalleVenta --
call sp_detalle_venta_create(1, 3500.00, 3500.00, 1,  1);
call sp_detalle_venta_create(1, 450.00,  450.00,  3,  2);
call sp_detalle_venta_create(2, 350.00,  700.00,  5,  3);
call sp_detalle_venta_create(2, 600.00,  1200.00, 7,  4);
call sp_detalle_venta_create(1, 950.00,  950.00,  9,  5);
call sp_detalle_venta_create(1, 3500.00, 3500.00, 1,  6);
call sp_detalle_venta_create(1, 1800.00, 1800.00, 4,  7);
call sp_detalle_venta_create(1, 800.00,  800.00,  6,  8);
call sp_detalle_venta_create(2, 350.00,  700.00,  5,  9);
call sp_detalle_venta_create(4, 120.00,  480.00,  10, 10);