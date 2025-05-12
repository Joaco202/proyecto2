CREATE TABLE roles (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL UNIQUE,
  descripcion TEXT
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE usuarios (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  usuario VARCHAR(50) NOT NULL UNIQUE,
  clave_hash VARCHAR(255) NOT NULL,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  correo VARCHAR(100) UNIQUE,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fecha_modificacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (rol_id) REFERENCES roles(id) ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE bodegas (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  ubicacion VARCHAR(255),
  descripcion TEXT,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE productos (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  codigo VARCHAR(50) NOT NULL UNIQUE,
  nombre VARCHAR(100) NOT NULL,
  descripcion TEXT,
  unidad VARCHAR(20),
  activo TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE lotes_producto (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  numero_lote VARCHAR(100),
  fecha_vencimiento DATE,
  cantidad DECIMAL(12,2) NOT NULL DEFAULT 0,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE,
  FOREIGN KEY (bodega_id)   REFERENCES bodegas(id)    ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE cargas_inventario (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cantidad    DECIMAL(12,2) NOT NULL,
  tipo_carga  ENUM('barrido','selectivo','general') NOT NULL,
  fecha_carga DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE,
  FOREIGN KEY (bodega_id)   REFERENCES bodegas(id)    ON DELETE CASCADE,
  FOREIGN KEY (usuario_id)  REFERENCES usuarios(id)   ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE listas_precios (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  fecha_vigencia DATE NOT NULL,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE elementos_lista_precios (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  precio          INT UNSIGNED NOT NULL,
  FOREIGN KEY (lista_precio_id) REFERENCES listas_precios(id) ON DELETE CASCADE,
  FOREIGN KEY (producto_id)     REFERENCES productos(id)      ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE beneficiarios (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  rut              VARCHAR(20) NOT NULL UNIQUE,
  tipo_documento   VARCHAR(10),
  numero_documento VARCHAR(50) NOT NULL UNIQUE,
  nombre           VARCHAR(50) NOT NULL,
  apellido         VARCHAR(80) NOT NULL,
  sexo             VARCHAR(20),NOT NULL, 
  fecha_nacimiento DATE,
  direccion        TEXT,
  telefono         VARCHAR(20),
  comuna           VARCHAR(100),
  correo           VARCHAR(100),
  fecha_creacion   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE historial_pacientes (
  id             INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  datos_historial TEXT,
  fecha_registro  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (beneficiario_id) REFERENCES beneficiarios(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE facturas (
  id             INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  numero_factura VARCHAR(50) NOT NULL UNIQUE,
  fecha          DATE NOT NULL,
  monto_total    DECIMAL(12,2),
  estado         VARCHAR(20) NOT NULL DEFAULT 'emitida',
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (beneficiario_id) REFERENCES beneficiarios(id) ON DELETE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE guias_despacho (
  id           INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  numero_guia  VARCHAR(50) NOT NULL UNIQUE,
  fecha        DATE NOT NULL,
  destino      TEXT,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (factura_id) REFERENCES facturas(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE ventas (
  id           INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  fecha_venta  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  monto_total  DECIMAL(12,2),
  FOREIGN KEY (factura_id) REFERENCES facturas(id) ON DELETE RESTRICT,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE elementos_venta (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cantidad    DECIMAL(12,2),
  precio      DECIMAL(12,2),
  descuento   DECIMAL(5,2) NOT NULL DEFAULT 0,
  FOREIGN KEY (venta_id)    REFERENCES ventas(id)           ON DELETE CASCADE,
  FOREIGN KEY (producto_id) REFERENCES productos(id)        ON DELETE RESTRICT,
  FOREIGN KEY (lote_id)     REFERENCES lotes_producto(id)   ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE compras (
  id              INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  numero_compra   VARCHAR(50) NOT NULL UNIQUE,
  fecha           DATE NOT NULL,
  proveedor       VARCHAR(100),
  monto_total     DECIMAL(12,2),
  estado          VARCHAR(20) NOT NULL DEFAULT 'recibido',
  fecha_creacion  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE elementos_compra (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cantidad    DECIMAL(12,2),
  precio      DECIMAL(12,2),
  FOREIGN KEY (compra_id)   REFERENCES compras(id)        ON DELETE CASCADE,
  FOREIGN KEY (producto_id) REFERENCES productos(id)      ON DELETE RESTRICT,
  FOREIGN KEY (lote_id)     REFERENCES lotes_producto(id) ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE notas_credito (
  id                  INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  numero_nota_credito VARCHAR(50) NOT NULL UNIQUE,
  fecha               DATE NOT NULL,
  monto               DECIMAL(12,2),
  motivo              TEXT,
  fecha_creacion      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (compra_id) REFERENCES compras(id) ON DELETE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE fraccionamientos (
  id                    INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cantidad              DECIMAL(12,2),
  fecha                 DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (producto_original_id) REFERENCES productos(id) ON DELETE RESTRICT,
  FOREIGN KEY (producto_fraccion_id) REFERENCES productos(id) ON DELETE RESTRICT,
  FOREIGN KEY (usuario_id)             REFERENCES usuarios(id)  ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE movimientos_inventario (
  id               INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  tipo_movimiento  ENUM('entrada','salida','transferencia') NOT NULL,
  modulo_referencia VARCHAR(50),
  id_referencia    INT UNSIGNED,
  cantidad         DECIMAL(12,2),
  fecha_movimiento DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (producto_id)      REFERENCES productos(id)      ON DELETE RESTRICT,
  FOREIGN KEY (lote_id)          REFERENCES lotes_producto(id) ON DELETE SET NULL,
  FOREIGN KEY (bodega_id)        REFERENCES bodegas(id)        ON DELETE RESTRICT,
  FOREIGN KEY (usuario_id)       REFERENCES usuarios(id)      ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE cajas (
  id             INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  fecha_registro DATE NOT NULL,
  monto_inicial  DECIMAL(12,2),
  monto_final    DECIMAL(12,2),
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE transacciones_caja (
  id               INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  tipo             ENUM('ingreso','egreso') NOT NULL,
  monto            DECIMAL(12,2),
  descripcion      TEXT,
  fecha_transaccion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (caja_id)    REFERENCES cajas(id)     ON DELETE CASCADE,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE dispersiones (
  id               INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  monto            DECIMAL(12,2),
  fecha            DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  estado           VARCHAR(20) NOT NULL DEFAULT 'pendiente',
  FOREIGN KEY (beneficiario_id) REFERENCES beneficiarios(id) ON DELETE RESTRICT,
  FOREIGN KEY (usuario_id)       REFERENCES usuarios(id)      ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE dispensaciones (
  id               INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cantidad         DECIMAL(12,2),
  fecha            DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (beneficiario_id) REFERENCES beneficiarios(id) ON DELETE RESTRICT,
  FOREIGN KEY (producto_id)       REFERENCES productos(id)    ON DELETE RESTRICT,
  FOREIGN KEY (lote_id)           REFERENCES lotes_producto(id) ON DELETE SET NULL,
  FOREIGN KEY (usuario_id)       REFERENCES usuarios(id)       ON DELETE SET NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE reglas_alerta (
  id                INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  intervalo_dias    INT,
  umbral_cantidad   DECIMAL(12,2),
  activo            TINYINT(1) NOT NULL DEFAULT 1,
  FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
