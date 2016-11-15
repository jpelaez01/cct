CREATE DEFINER=`root`@`localhost` TRIGGER `cct_db`.`propuesta_cliente_AFTER_UPDATE` AFTER UPDATE ON `propuesta_cliente` FOR EACH ROW
BEGIN
IF NEW.estado_propuesta = "Cerrada" THEN
INSERT INTO `cct_db_segura`.`propuesta_cliente`
(`cliente_id`,
`propuesta_socio_id`,
`fecha_creacion_propuesta`,
`fecha_presentacion_propuesta`,
`estado_propuesta`,
`proyecto_id`,
`viable_tecnicamente`,
`viable_financieramente`,
`fecha_aceptacion`,
`propuesta_clientecol`,
`valor_total`)
VALUES
(NEW.cliente_id,
NEW.propuesta_socio_id,
NEW.fecha_creacion_propuesta,
NEW.fecha_presentacion_propuesta,
NEW.estado_propuesta,
NEW.proyecto_id,
NEW.viable_tecnicamente,
NEW.viable_financieramente,
NEW.fecha_aceptacion,
NEW.propuesta_clientecol,
NEW.valor_total);

SELECT * FROM cct_db.propuesta_cliente WHERE NEW.propuesta_cliente_id = propuesta_cliente_id
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/propuesta.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY ''
LINES TERMINATED BY '\n';

END IF;
END