
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `data_cadastro` date NOT NULL,
  `nome` varchar(255) NOT NULL,
  `quantidade` varchar(255) NOT NULL,
  `valor_unitario` decimal(10,2) NOT NULL,
  `valor_total` decimal(10,2) NOT NULL,
  `desconto` decimal(10,2) NOT NULL,
  `codigo_cliente` int unsigned NOT NULL,
  `numero_controle` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_numero_controle` (`numero_controle`),
  KEY `FK_cliente` (`codigo_cliente`),
  CONSTRAINT `FK_cliente` FOREIGN KEY (`codigo_cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

