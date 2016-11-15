CREATE DEFINER=`root`@`localhost` TRIGGER `cct_db_segura`.`propuesta_cliente_BEFORE_UPDATE` BEFORE UPDATE ON `propuesta_cliente` FOR EACH ROW
BEGIN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se pueden modificar propuestas cerradas';
END