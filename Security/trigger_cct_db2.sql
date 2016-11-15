CREATE DEFINER=`root`@`localhost` TRIGGER `cct_db`.`propuesta_cliente_BEFORE_UPDATE` BEFORE UPDATE ON `propuesta_cliente` FOR EACH ROW
BEGIN
if  OLD.estado_propuesta = 'Cerrada' then 
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se pueden modificar propuestas cerradas';
end if;
END