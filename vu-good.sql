-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-12-2025 a las 02:26:31
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vu-good`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `id_direccion` int(11) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `codigo_postal` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`id_direccion`, `ciudad`, `codigo_postal`, `direccion`, `pais`) VALUES
(1, 'Medellin', '110024', 'Veguito # 01 - 01', 'Colombia'),
(2, 'Medellin', '110024', 'Veguito # 01 - 01', 'Colombia'),
(3, 'Medellin', '110020', 'Avenida good # 01 - 01', 'Colombia'),
(4, 'Cali', '110025', 'calle 14h # 01 - 01', 'Colombia'),
(6, 'Medellin', '110020', 'Avenida good # 01 - 01', 'Colombia'),
(7, 'Cali', '180018', 'Avenida salo # 18 - 18', 'Colombia'),
(8, 'Cali', '180018', 'Avenida salo # 18 - 18', 'Colombia'),
(9, 'Cali', '180018', 'Avenida salo # 18 - 18', 'Colombia'),
(10, 'Cali', '180018', 'Avenida salo # 18 - 18', 'Colombia'),
(11, 'Cali', '180018', 'Avenida salo # 18 - 18', 'Colombia'),
(12, 'Cali', '180018', 'Avenida salo # 18 - 18', 'Colombia'),
(13, 'Cali', '180018', 'Avenida saraca # 18 - 18', 'Colombia'),
(14, 'Boyaca', '180018', 'Avenida gama # 18 - 18', 'Colombia'),
(16, 'Tunja', '180018', 'Avenida rasp # 18 - 18', 'Colombia'),
(17, 'Tunja', '180018', 'Avenida rasp # 18 - 18', 'Colombia'),
(18, 'Tunja', '180018', 'Avenida rasp # 18 - 18', 'Colombia'),
(19, 'Ibague', '180018', 'Avenida loki # 18 - 18', 'Colombia'),
(20, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(21, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(22, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(23, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(24, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(25, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(26, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(27, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(28, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(29, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(30, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(31, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(32, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(33, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(34, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(35, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(36, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(37, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(38, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(39, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(40, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(41, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(42, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(45, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(46, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(47, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(48, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(49, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(50, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(51, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(52, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(53, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(54, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(55, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(56, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(57, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(58, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(63, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(65, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(66, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(67, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(68, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(69, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(70, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(71, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(72, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(73, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(74, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(85, 'IBAGUE', '180018', 'Avenida loki # 18 - 18', 'COLOMBIA'),
(88, 'MEDELLIN', '180018', 'Avenida paco # 18 - 18', 'COLOMBIA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `id_mensaje` int(11) NOT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `estado_mensaje` varchar(255) DEFAULT NULL,
  `men_created_at` date DEFAULT NULL,
  `men_descripcion` varchar(255) DEFAULT NULL,
  `men_updated_at` date DEFAULT NULL,
  `mensaje` varchar(5000) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`id_mensaje`, `codigo`, `estado_mensaje`, `men_created_at`, `men_descripcion`, `men_updated_at`, `mensaje`, `tipo`) VALUES
(1, 'men.error.id.mensaje.notFound', 'A', '2025-06-21', 'Mensaje de error registro no encontrado en la base de datos', '2025-06-21', 'ERROR ID: Id no encontrado en la base de datos!', 'BASICO'),
(2, 'men.error.id.rol.notFound', 'A', '2025-06-21', 'Mensaje de error registro no encontrado en la base de datos', NULL, 'ERROR ID: Rol no encontrado!', 'BASICO'),
(5, 'usu.error.id.usu.notFound', 'A', '2025-06-21', 'Mensaje de error registro usuario no encontrado en la base de datos', NULL, 'ERROR ID: Usuario Id no encotrado!', 'BASICO'),
(6, 'men.error.mensaje.created', 'A', '2025-06-21', 'ERROR: al crear un registro Mensaje en la base de datos', '2025-06-21', 'ERROR: Al crear Mensaje Del Sistema!', 'BASICO'),
(8, 'men.error.mensaje.updated', 'A', '2025-06-21', 'ERROR: al actualizar un registro Mensaje en la base de datos', NULL, 'ERROR: Actualizar Mensaje Del Sistema!', 'BASICO'),
(9, 'men.vali.codigo.dto', 'A', '2025-06-21', 'Codigo Mensaje es neceario', NULL, 'Codigo Mensaje necesario!', 'BASICO'),
(14, 'men.exito.mensaje.delete', 'A', '2025-06-22', 'Mensaje Del Sistema eliminado con exito', '2025-06-22', 'Mensaje Del Sistema eliminado con exito', 'BASICO'),
(15, 'men.notFound.mensaje', 'A', '2025-06-22', 'Mensaje Del Sistema no encontrado', NULL, 'Mensaje no encontrado', 'BASICO'),
(16, 'men.vali.mensaje.dto', 'A', '2025-06-22', 'Mensaje es necesario para crear el registro', NULL, 'Mensaje es necesario!', 'BASICO'),
(17, 'men.vali.tipo.dto', 'A', '2025-06-22', 'Tipo Mensaje es necesario para crear el registro', NULL, 'Tipo Mensaje es necesario!', 'BASICO'),
(18, 'men.vali.descripcion.dto', 'A', '2025-06-22', 'Descripcion Mensaje es necesaria!', NULL, 'Descripcion Mensaje es necesaria!', 'BASICO'),
(19, 'men.vali.estado.dto', 'A', '2025-06-22', 'Estado Mensaje es necesario para crear el registro', NULL, 'Estado Mensaje es necesario!', 'BASICO'),
(20, 'error.handler.MethodArgumentNotValid', 'A', '2025-06-22', 'Solicitud no procesada metodo MethodArgumentNotValidException', NULL, 'Solicitud no procesada!', 'BASICO'),
(21, 'error.handler.MethodArgumentNotValid.detail', 'A', '2025-06-22', 'La solicitud no puede procesarse porque tiene errores', NULL, 'La solicitud no puede procesarse porque tiene errores', 'BASICO'),
(22, 'error.handler.badRequestException', 'A', '2025-06-22', 'Solicitud Incorrecta', NULL, 'Solicitud Incorrecta', 'BASICO'),
(23, 'error.handler.notFoundException', 'A', '2025-06-22', 'Solicitud No encontrada', NULL, 'Solicitud No encontrada', 'BASICO'),
(24, 'rol.vali.dto', 'A', '2025-06-22', 'Rol es necesario para crear el registro', NULL, 'Rol es necesario!', 'BASICO'),
(25, 'rol.vali.max.dto', 'A', '2025-06-22', 'Rol puede tener maximo 3 caracteres para crear el registro!', NULL, 'Rol puede tener maximo 3 caracteres!', 'BASICO'),
(26, 'rol.vali.descripcion.dto', 'A', '2025-06-22', 'Descripcion rol es necesaria!!', NULL, 'Descripcion rol es necesaria!', 'BASICO'),
(27, 'rol.vali.estado.dto', 'A', '2025-06-22', 'Estado del Rol es necesario!', NULL, 'Estado del Rol es necesario!', 'BASICO'),
(28, 'dir.vali.direccion.dto', 'A', '2025-06-22', 'La dirección es obligatoria para crear el registro', NULL, 'La dirección es obligatoria', 'BASICO'),
(29, 'dir.vali.pais.dto', 'A', '2025-06-22', 'El país es obligatorio para crear el registro', NULL, 'El país es obligatorio', 'BASICO'),
(30, 'dir.vali.ciudad.dto', 'A', '2025-06-22', 'La ciudad es obligatoria para crear el registro', NULL, 'La ciudad es obligatoria', 'BASICO'),
(31, 'usu.vali.nombre.dto', 'A', '2025-06-22', 'Nombre es necesario para crear el registro', NULL, 'Nombre es necesario!', 'BASICO'),
(32, 'usu.vali.min.nombre.dto', 'A', '2025-06-22', 'Nombre debe tener almenos 3 caracteres para crear el registro', NULL, 'Nombre debe tener almenos 3 caracteres!', 'BASICO'),
(33, 'usu.vali.max.nombre.dto', 'A', '2025-06-22', 'Nombre debe tener maximo 100 caracteres para crear el registro', NULL, 'Nombre debe tener maximo 100 caracteres!', 'BASICO'),
(35, 'usu.vali.apellido.dto', 'A', '2025-06-22', 'Apellido es necesario para crear el registro', NULL, 'Apellido es necesario!', 'BASICO'),
(36, 'usu.vali.min.apellido.dto', 'A', '2025-06-22', 'Apellido debe tener almenos 3 caracteres para crear el registro', NULL, 'Apellido debe tener almenos 3 caracteres!', 'BASICO'),
(37, 'usu.vali.max.apellido.dto', 'A', '2025-06-22', 'Apellido debe tener maximo 100 caracteres para crear el registro', NULL, 'Apellido debe tener maximo 100 caracteres!', 'BASICO'),
(38, 'usu.vali.documento.dto', 'A', '2025-06-22', 'Documento es necesario para crear el registro', NULL, 'Documento es necesario!', 'BASICO'),
(39, 'usu.vali.email.dto', 'A', '2025-06-22', 'Email es necesario para crear el registro', NULL, 'Email es necesario!', 'BASICO'),
(40, 'usu.vali.email.formato.dto', 'A', '2025-06-22', 'Email debe tener un formato @ valido para crear el registro', NULL, 'Email debe tener un formato @ valido!', 'BASICO'),
(41, 'usu.vali.password.dto', 'A', '2025-06-22', 'Contraseña es necesaria para crear el registro', NULL, 'Contraseña es necesaria!', 'BASICO'),
(42, 'usu.vali.min.password.dto', 'A', '2025-06-22', 'La contraseña debe tener al menos 5 caracteres para crear el registro', NULL, 'La contraseña debe tener al menos 5 caracteres!', 'BASICO'),
(43, 'usu.vali.min.celular.dto', 'A', '2025-06-22', 'La contraseña debe tener al menos 5 caracteres para crear el registro', '2025-06-22', 'Celular debe tener 10 numeros!', 'BASICO'),
(44, 'usu.vali.celular.dto', 'A', '2025-06-22', 'Celular es requerido para crear el registro', NULL, 'Celular es requerido!', 'BASICO'),
(45, 'usu.vali.img.dto', 'A', '2025-06-22', 'Imagen necesaria para crear el registro', NULL, 'Imagen necesaria!', 'BASICO'),
(46, 'usu.vali.estado.dto', 'A', '2025-06-22', 'Estado usuario es necesario para crear el registro', NULL, 'Estado usuario es necesario!', 'BASICO'),
(47, 'usu.vali.direccion.dto', 'A', '2025-06-22', 'La dirección del usuario no puede ser nula para crear el registro', NULL, 'La dirección del usuario no puede ser nula!', 'BASICO'),
(48, 'men.cache.restset.manual', 'A', '2025-06-23', 'Caché de mensajes reiniciada manualmente.', NULL, 'Caché de mensajes reiniciada manualmente.', 'BASICO'),
(49, 'men.pre.cache.ram.mensajes', 'A', '2025-06-23', 'Registros \'mensajes\' precargandos en Caché.', NULL, 'Registros \'mensajes\' precargandos en Caché.', 'BASICO'),
(50, 'men.cache.reiniciada.mensajes', 'A', '2025-06-23', 'Caché de mensajes reiniciada correctamente.', NULL, 'Caché de mensajes reiniciada correctamente.', 'BASICO'),
(51, 'usu.tipoDoc.notFound', 'A', '2025-06-29', 'Tipo documento no encontrado al crear registro !', NULL, 'Tipo documento no encontrado!', 'BASICO'),
(52, 'usu.vali.tipoDoc.dto', 'A', '2025-06-29', 'El tipo de documento es obligatorio !', NULL, 'El tipo de documento es obligatorio!', 'BASICO'),
(53, 'usu.error.email.duplicado', 'A', '2025-06-29', 'El email ya existe para crear el registro!', NULL, 'El email ya existe!', 'BASICO'),
(54, 'usu.error.created', 'A', '2025-06-29', 'ERROR CREACION USU: No es posible realizar el proceso!', NULL, 'ERROR CREACION USU: No es posible realizar el proceso!', 'BASICO'),
(55, 'usu.error.updated', 'A', '2025-06-29', 'ERROR UPDATE USU: No es posible realizar el proceso!', NULL, 'ERROR UPDATE USU: No es posible realizar el proceso!', 'BASICO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `id` int(11) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `mensaje_respuesta` varchar(500) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `tema_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado_rol` varchar(255) DEFAULT NULL,
  `id_permiso` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `rol_created_at` date DEFAULT NULL,
  `rol_update_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `descripcion`, `estado_rol`, `id_permiso`, `rol`, `rol_created_at`, `rol_update_at`) VALUES
(1, 'Administrador', 'A', NULL, 'ADM', '2025-05-10', NULL),
(2, 'Cliente', 'A', NULL, 'CLI', '2025-05-10', NULL),
(3, 'Usuario', 'A', NULL, 'USU', '2025-05-10', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tema`
--

CREATE TABLE `tema` (
  `id` int(11) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `genero` enum('COCINA','DEPORTE','TECNOLOGIA','VIDEO_JUEGOS') DEFAULT NULL,
  `mensaje` varchar(1500) DEFAULT NULL,
  `titulo` varchar(150) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_doc`
--

CREATE TABLE `tipo_doc` (
  `id_doc` int(11) NOT NULL,
  `codi_doc` varchar(255) DEFAULT NULL,
  `descri_doc` varchar(255) DEFAULT NULL,
  `doc_created_at` date DEFAULT NULL,
  `doc_update_at` date DEFAULT NULL,
  `estado_doc` varchar(255) DEFAULT NULL,
  `nom_doc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tipo_doc`
--

INSERT INTO `tipo_doc` (`id_doc`, `codi_doc`, `descri_doc`, `doc_created_at`, `doc_update_at`, `estado_doc`, `nom_doc`) VALUES
(1, 'CC', 'Cedula De Ciudadania Colombiana', NULL, NULL, 'A', 'CEDULA'),
(2, 'TI', 'Tarjeta Identidad', NULL, NULL, 'A', 'TARJETA IDENTIDAD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `file_perfil` varchar(255) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `usu_created_at` date DEFAULT NULL,
  `usu_update_at` date DEFAULT NULL,
  `id_usuario_data` bigint(20) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `usu_created_at`, `usu_update_at`, `id_usuario_data`, `id_rol`) VALUES
(1, '2025-05-18', '2025-05-18', 1, 3),
(2, '2025-05-18', NULL, 2, 3),
(3, '2025-05-18', NULL, 3, 1),
(5, '2025-05-19', '2025-05-19', 5, 3),
(6, '2025-06-13', NULL, 6, 1),
(7, '2025-06-13', NULL, 7, 1),
(8, '2025-06-21', NULL, 8, 1),
(10, '2025-06-22', NULL, 10, 2),
(11, '2025-06-22', NULL, 11, 2),
(12, '2025-06-24', NULL, 12, 2),
(13, '2025-06-24', NULL, 13, 3),
(14, '2025-06-24', NULL, 14, 3),
(15, '2025-06-24', NULL, 15, 3),
(16, '2025-06-24', NULL, 16, 3),
(17, '2025-06-24', NULL, 17, 3),
(18, '2025-06-24', NULL, 18, 3),
(19, '2025-06-24', NULL, 19, 3),
(20, '2025-06-24', NULL, 20, 1),
(21, '2025-06-24', NULL, 21, 1),
(22, '2025-06-24', NULL, 22, 3),
(23, '2025-06-24', NULL, 23, 3),
(24, '2025-06-24', NULL, 24, 3),
(25, '2025-06-24', NULL, 25, 3),
(26, '2025-06-24', NULL, 26, 3),
(27, '2025-06-24', NULL, 27, 3),
(28, '2025-06-24', NULL, 28, 3),
(29, '2025-06-24', NULL, 29, 3),
(30, '2025-06-24', NULL, 30, 2),
(31, '2025-06-24', NULL, 31, 3),
(32, '2025-06-24', NULL, 32, 3),
(33, '2025-06-24', NULL, 33, 2),
(34, '2025-06-24', '2025-07-05', 34, 2),
(35, '2025-06-24', '2025-06-29', 35, 2),
(36, '2025-06-25', NULL, 36, 2),
(37, '2025-06-25', NULL, 37, 2),
(38, '2025-06-29', NULL, 38, 2),
(39, '2025-07-05', '2025-07-05', 39, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_data`
--

CREATE TABLE `usuario_data` (
  `id_usu_data` bigint(20) NOT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estado_usu` varchar(255) DEFAULT NULL,
  `img_usu` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `usu_lastname` varchar(255) DEFAULT NULL,
  `usu_name` varchar(255) DEFAULT NULL,
  `id_direccion` int(11) DEFAULT NULL,
  `usu_documento` varchar(255) DEFAULT NULL,
  `tipo_doc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuario_data`
--

INSERT INTO `usuario_data` (`id_usu_data`, `celular`, `email`, `estado_usu`, `img_usu`, `password`, `usu_lastname`, `usu_name`, `id_direccion`, `usu_documento`, `tipo_doc`) VALUES
(1, '3111110909', 'lili@gmail.com', 'A', 'lili.jpeg', 'lili', 'master', 'lili', 4, '9398587878', NULL),
(2, '313222334', 'vegueta@vegueta.com', 'A', 'vegueta.jpeg', 'vegueta', 'sayayin', 'vege', 2, '9009099999', NULL),
(3, '3001001010', 'juls@gmail.com', 'A', 'juls.jpeg', 'juls', 'juls', 'juls', 3, '2002', NULL),
(5, '3022001010', 'j@gmail.com', 'I', 'j.jpeg', 'juls', 'j', 'j', 6, '2222', NULL),
(6, '3009993399', 'saloca@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'saloca', 'saloca', 'salome', 12, '1818', NULL),
(7, '3019993399', 'saraca@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'saraca', 'saraca', 'saray', 13, '1424', NULL),
(8, '3223334455', 'gamaguchi@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'gamaguchi', 'agamagu', 'gamaguchi', 14, '4565464545', NULL),
(10, '3290909090', 'raspverry@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'raspverry', 'verry', 'rasp', 18, '55555555', NULL),
(11, '3190909090', 'loki@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'loki77', 'loku', 'loki', 19, '77777777', NULL),
(12, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 20, '11111141', NULL),
(13, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 22, '11111141', NULL),
(14, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 23, '11111141', NULL),
(15, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 24, '11111141', NULL),
(16, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 25, '11111141', NULL),
(17, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 26, '11111141', NULL),
(18, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 27, '11111141', NULL),
(19, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 28, '11111141', NULL),
(20, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 29, '11111141', NULL),
(21, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 30, '11111141', NULL),
(22, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 31, '11111141', NULL),
(23, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 32, '11111141', NULL),
(24, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 33, '11111141', NULL),
(25, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 34, '11111141', NULL),
(26, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 35, '11111141', NULL),
(27, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 36, '11111141', NULL),
(28, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 37, '11111141', NULL),
(29, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 38, '11111141', NULL),
(30, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 39, '11111141', NULL),
(31, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 40, '11111141', NULL),
(32, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 41, '11111141', NULL),
(33, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 42, '11111141', NULL),
(34, '3091020093', 'adminn32@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 85, '11111111', 2),
(35, '3090000090', 'adminn@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 69, '11111141', 2),
(36, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 45, '11111141', 2),
(37, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 46, '11111141', 2),
(38, '3090000090', 'admin@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', 'admin', 'admin', 'admin', 48, '11111141', 2),
(39, '3090990909', 'pacolaco@gmail.com', 'A', '4c50e1d1-6de2-4472-b916-58fbc9166b21.png', '$2a$10$QPuLZfJS/gY1LOYhDrl4xelfuakijEGgIrLOmjSoG./BNdo.gViI6', 'Laco', 'Paco', 88, '32324544', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`id_direccion`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`id_mensaje`),
  ADD UNIQUE KEY `UKh3lfrgbed6xduhbgsvnvdpmot` (`codigo`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjg4e87hihpksk2xciteys3ooa` (`tema_id`),
  ADD KEY `FKctn14ljjyruo647pixtk6c9e7` (`usuario_id`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `tema`
--
ALTER TABLE `tema`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_h3jis1ou98xko52v2b6qpobb5` (`titulo`),
  ADD UNIQUE KEY `UK_bhn57cabg81ndyt9mvp1ax5tw` (`mensaje`) USING HASH,
  ADD KEY `FK2t2rdg43x834hjuahfk1nvy32` (`usuario_id`);

--
-- Indices de la tabla `tipo_doc`
--
ALTER TABLE `tipo_doc`
  ADD PRIMARY KEY (`id_doc`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `UKtesyavbbmwcx56ktiyvkx0u1c` (`id_usuario_data`),
  ADD KEY `FK5ubh1vhgk6g42j7twprjlvmpu` (`id_rol`);

--
-- Indices de la tabla `usuario_data`
--
ALTER TABLE `usuario_data`
  ADD PRIMARY KEY (`id_usu_data`),
  ADD KEY `FK541tiiuvdhyo520w8r5yxxjgw` (`id_direccion`),
  ADD KEY `FK9msyinhn4c724172qpfs1hlvd` (`tipo_doc`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `id_direccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;

--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `id_mensaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tema`
--
ALTER TABLE `tema`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_doc`
--
ALTER TABLE `tipo_doc`
  MODIFY `id_doc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `usuario_data`
--
ALTER TABLE `usuario_data`
  MODIFY `id_usu_data` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `FKctn14ljjyruo647pixtk6c9e7` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKjg4e87hihpksk2xciteys3ooa` FOREIGN KEY (`tema_id`) REFERENCES `tema` (`id`);

--
-- Filtros para la tabla `tema`
--
ALTER TABLE `tema`
  ADD CONSTRAINT `FK2t2rdg43x834hjuahfk1nvy32` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK5ubh1vhgk6g42j7twprjlvmpu` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`),
  ADD CONSTRAINT `FKnote5b8b8dkf9a1607bvtoum5` FOREIGN KEY (`id_usuario_data`) REFERENCES `usuario_data` (`id_usu_data`);

--
-- Filtros para la tabla `usuario_data`
--
ALTER TABLE `usuario_data`
  ADD CONSTRAINT `FK541tiiuvdhyo520w8r5yxxjgw` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id_direccion`),
  ADD CONSTRAINT `FK9msyinhn4c724172qpfs1hlvd` FOREIGN KEY (`tipo_doc`) REFERENCES `tipo_doc` (`id_doc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
