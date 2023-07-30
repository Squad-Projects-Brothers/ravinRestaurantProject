--
-- PostgreSQL database dump
--

-- Dumped from database version 14.8
-- Dumped by pg_dump version 14.8

-- Started on 2023-07-30 19:29:14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3421 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 228 (class 1259 OID 25442)
-- Name: cardapio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cardapio (
    id integer NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.cardapio OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 25441)
-- Name: cardapio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cardapio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cardapio_id_seq OWNER TO postgres;

--
-- TOC entry 3422 (class 0 OID 0)
-- Dependencies: 227
-- Name: cardapio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cardapio_id_seq OWNED BY public.cardapio.id;


--
-- TOC entry 230 (class 1259 OID 25449)
-- Name: cardapioproduto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cardapioproduto (
    id integer NOT NULL,
    cardapio_id integer,
    produto_id integer
);


ALTER TABLE public.cardapioproduto OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 25448)
-- Name: cardapioproduto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cardapioproduto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cardapioproduto_id_seq OWNER TO postgres;

--
-- TOC entry 3423 (class 0 OID 0)
-- Dependencies: 229
-- Name: cardapioproduto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cardapioproduto_id_seq OWNED BY public.cardapioproduto.id;


--
-- TOC entry 214 (class 1259 OID 25356)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id integer NOT NULL,
    pessoa_id integer NOT NULL,
    observacao text
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 25355)
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_seq OWNER TO postgres;

--
-- TOC entry 3424 (class 0 OID 0)
-- Dependencies: 213
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;


--
-- TOC entry 224 (class 1259 OID 25409)
-- Name: comanda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comanda (
    id integer NOT NULL,
    mesa_id integer NOT NULL,
    codigo character varying(50) NOT NULL,
    observacoes text,
    statuscomanda character varying(50) NOT NULL,
    valortotal double precision NOT NULL
);


ALTER TABLE public.comanda OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 25408)
-- Name: comanda_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comanda_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comanda_id_seq OWNER TO postgres;

--
-- TOC entry 3425 (class 0 OID 0)
-- Dependencies: 223
-- Name: comanda_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comanda_id_seq OWNED BY public.comanda.id;


--
-- TOC entry 210 (class 1259 OID 25335)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    id integer NOT NULL,
    cep character varying(10) NOT NULL,
    cidade character varying(100),
    estado character varying(50),
    rua character varying(100),
    numero integer NOT NULL,
    bairro character varying(100),
    complemento character varying(200)
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 25334)
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endereco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endereco_id_seq OWNER TO postgres;

--
-- TOC entry 3426 (class 0 OID 0)
-- Dependencies: 209
-- Name: endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endereco_id_seq OWNED BY public.endereco.id;


--
-- TOC entry 216 (class 1259 OID 25370)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    id integer NOT NULL,
    pessoa_id integer NOT NULL,
    rg character varying(50) NOT NULL,
    estado_civil character varying(200),
    escolaridade character varying(200),
    cargo character varying(200),
    numero_carteira_trabalho character varying(50),
    data_admissao date,
    data_demissao date,
    disponivel boolean
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 25369)
-- Name: funcionario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.funcionario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.funcionario_id_seq OWNER TO postgres;

--
-- TOC entry 3427 (class 0 OID 0)
-- Dependencies: 215
-- Name: funcionario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.funcionario_id_seq OWNED BY public.funcionario.id;


--
-- TOC entry 222 (class 1259 OID 25402)
-- Name: mesa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mesa (
    id integer NOT NULL,
    codigo character varying(50) NOT NULL,
    numero integer NOT NULL,
    statusmesa character varying(50) NOT NULL,
    capacidade integer NOT NULL
);


ALTER TABLE public.mesa OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 25401)
-- Name: mesa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mesa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mesa_id_seq OWNER TO postgres;

--
-- TOC entry 3428 (class 0 OID 0)
-- Dependencies: 221
-- Name: mesa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mesa_id_seq OWNED BY public.mesa.id;


--
-- TOC entry 226 (class 1259 OID 25423)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    id integer NOT NULL,
    produto_id integer NOT NULL,
    comanda_id integer NOT NULL,
    datahorasolicitacao timestamp without time zone NOT NULL,
    datahorainiciopreparo timestamp without time zone,
    tempopreparorestante timestamp without time zone,
    statuspreparo character varying(50) NOT NULL,
    observacao text,
    quantidade integer NOT NULL
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 25422)
-- Name: pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_id_seq OWNER TO postgres;

--
-- TOC entry 3429 (class 0 OID 0)
-- Dependencies: 225
-- Name: pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedido_id_seq OWNED BY public.pedido.id;


--
-- TOC entry 212 (class 1259 OID 25344)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    cpf character varying(14) NOT NULL,
    telefone character varying(20),
    data_nascimento date,
    id_endereco integer,
    ativo boolean NOT NULL
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 25343)
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pessoa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 3430 (class 0 OID 0)
-- Dependencies: 211
-- Name: pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pessoa_id_seq OWNED BY public.pessoa.id;


--
-- TOC entry 220 (class 1259 OID 25393)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    descricao character varying(200),
    codigo character varying(50) NOT NULL,
    precocusto numeric(10,2) NOT NULL,
    precovenda numeric(10,2) NOT NULL,
    tempopreparo character varying(50),
    observacoes text,
    tipoproduto character varying(50) NOT NULL,
    ativo boolean NOT NULL
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 25392)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_id_seq OWNER TO postgres;

--
-- TOC entry 3431 (class 0 OID 0)
-- Dependencies: 219
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;


--
-- TOC entry 218 (class 1259 OID 25384)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    login character varying(50) NOT NULL,
    senha character varying(100) NOT NULL,
    tipousuario character varying(50) NOT NULL,
    ativo boolean NOT NULL,
    logado boolean NOT NULL,
    criadopor character varying(100) NOT NULL,
    criadoem date NOT NULL,
    alteradopor character varying(100),
    alteradoem date
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 25383)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 3432 (class 0 OID 0)
-- Dependencies: 217
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- TOC entry 3223 (class 2604 OID 25445)
-- Name: cardapio id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cardapio ALTER COLUMN id SET DEFAULT nextval('public.cardapio_id_seq'::regclass);


--
-- TOC entry 3224 (class 2604 OID 25452)
-- Name: cardapioproduto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cardapioproduto ALTER COLUMN id SET DEFAULT nextval('public.cardapioproduto_id_seq'::regclass);


--
-- TOC entry 3216 (class 2604 OID 25359)
-- Name: cliente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);


--
-- TOC entry 3221 (class 2604 OID 25412)
-- Name: comanda id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comanda ALTER COLUMN id SET DEFAULT nextval('public.comanda_id_seq'::regclass);


--
-- TOC entry 3214 (class 2604 OID 25338)
-- Name: endereco id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco ALTER COLUMN id SET DEFAULT nextval('public.endereco_id_seq'::regclass);


--
-- TOC entry 3217 (class 2604 OID 25373)
-- Name: funcionario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario ALTER COLUMN id SET DEFAULT nextval('public.funcionario_id_seq'::regclass);


--
-- TOC entry 3220 (class 2604 OID 25405)
-- Name: mesa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mesa ALTER COLUMN id SET DEFAULT nextval('public.mesa_id_seq'::regclass);


--
-- TOC entry 3222 (class 2604 OID 25426)
-- Name: pedido id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido ALTER COLUMN id SET DEFAULT nextval('public.pedido_id_seq'::regclass);


--
-- TOC entry 3215 (class 2604 OID 25347)
-- Name: pessoa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa ALTER COLUMN id SET DEFAULT nextval('public.pessoa_id_seq'::regclass);


--
-- TOC entry 3219 (class 2604 OID 25396)
-- Name: produto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- TOC entry 3218 (class 2604 OID 25387)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- TOC entry 3413 (class 0 OID 25442)
-- Dependencies: 228
-- Data for Name: cardapio; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cardapio VALUES (1, 'Cardápio de Verão');
INSERT INTO public.cardapio VALUES (2, 'Cardápio de Inverno');
INSERT INTO public.cardapio VALUES (3, 'Cardápio de Bebidas');
INSERT INTO public.cardapio VALUES (4, 'Cardápio de Sobremesas');


--
-- TOC entry 3415 (class 0 OID 25449)
-- Dependencies: 230
-- Data for Name: cardapioproduto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cardapioproduto VALUES (1, 1, 1);
INSERT INTO public.cardapioproduto VALUES (2, 1, 2);
INSERT INTO public.cardapioproduto VALUES (3, 1, 5);
INSERT INTO public.cardapioproduto VALUES (4, 2, 2);
INSERT INTO public.cardapioproduto VALUES (5, 2, 4);
INSERT INTO public.cardapioproduto VALUES (6, 2, 5);
INSERT INTO public.cardapioproduto VALUES (7, 3, 3);
INSERT INTO public.cardapioproduto VALUES (8, 4, 4);
INSERT INTO public.cardapioproduto VALUES (9, 4, 5);


--
-- TOC entry 3399 (class 0 OID 25356)
-- Dependencies: 214
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cliente VALUES (1, 1, 'Cliente fiel e frequente.');
INSERT INTO public.cliente VALUES (2, 2, 'Cliente novo, atendimento personalizado.');
INSERT INTO public.cliente VALUES (3, 3, 'Cliente preferencial, descontos especiais.');
INSERT INTO public.cliente VALUES (4, 4, 'Cliente ocasional, recomendação para promoções.');
INSERT INTO public.cliente VALUES (5, 5, 'Cliente VIP, tratamento especializado.');


--
-- TOC entry 3409 (class 0 OID 25409)
-- Dependencies: 224
-- Data for Name: comanda; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.comanda VALUES (1, 1, 'CMD001', 'Comanda para família', 'EM_ABERTO', 0);
INSERT INTO public.comanda VALUES (2, 2, 'CMD002', 'Comanda para festa', 'FECHADA', 50);
INSERT INTO public.comanda VALUES (3, 3, 'CMD003', 'Comanda para casal', 'EM_ABERTO', 0);
INSERT INTO public.comanda VALUES (4, 4, 'CMD004', 'Comanda para aniversário', 'FECHADA', 75.5);
INSERT INTO public.comanda VALUES (5, 5, 'CMD005', 'Comanda para grupo', 'EM_ABERTO', 0);
INSERT INTO public.comanda VALUES (6, 6, 'CMD006', 'Comanda para celebração', 'EM_ABERTO', 30);
INSERT INTO public.comanda VALUES (7, 7, 'CMD007', 'Comanda para reunião', 'EM_ABERTO', 0);
INSERT INTO public.comanda VALUES (8, 8, 'CMD008', 'Comanda para confraternização', 'FECHADA', 65);
INSERT INTO public.comanda VALUES (9, 9, 'CMD009', 'Comanda para dupla', 'EM_ABERTO', 0);
INSERT INTO public.comanda VALUES (10, 10, 'CMD010', 'Comanda para evento', 'FECHADA', 100);


--
-- TOC entry 3395 (class 0 OID 25335)
-- Dependencies: 210
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.endereco VALUES (1, '12345-678', 'Cidade A', 'Estado X', 'Rua Principal', 100, 'Centro', NULL);
INSERT INTO public.endereco VALUES (2, '98765-432', 'Cidade B', 'Estado Y', 'Avenida Secundária', 500, 'Bairro Novo', 'Bloco C');
INSERT INTO public.endereco VALUES (3, '54321-876', 'Cidade C', 'Estado Z', 'Praça da Esquina', 25, 'Vila Feliz', NULL);
INSERT INTO public.endereco VALUES (4, '11111-222', 'Cidade D', 'Estado W', 'Rua das Flores', 50, 'Jardim Encantado', NULL);
INSERT INTO public.endereco VALUES (5, '33333-444', 'Cidade E', 'Estado V', 'Rua da Colina', 30, 'Bairro Antigo', 'Casa 10');


--
-- TOC entry 3401 (class 0 OID 25370)
-- Dependencies: 216
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.funcionario VALUES (1, 6, '12.345.678-9', 'SOLTEIRO', 'MEDIO', 'GARCON', '123456', '2021-01-15', NULL, true);
INSERT INTO public.funcionario VALUES (2, 7, '98.765.432-1', 'CASADO', 'SUPERIOR', 'GERENTE', '654321', '2019-05-10', NULL, true);
INSERT INTO public.funcionario VALUES (3, 8, '56.789.012-3', 'SOLTEIRO', 'MEDIO', 'COZINHEIRO', '789012', '2022-03-20', NULL, true);
INSERT INTO public.funcionario VALUES (4, 9, '11.222.333-4', 'CASADO', 'SUPERIOR', 'GARCON', '222333', '2020-11-25', NULL, true);
INSERT INTO public.funcionario VALUES (5, 10, '55.66.77-88', 'SOLTEIRO', 'MEDIO', 'GARCON', '666777', '2023-02-05', NULL, true);


--
-- TOC entry 3407 (class 0 OID 25402)
-- Dependencies: 222
-- Data for Name: mesa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.mesa VALUES (1, 'M01', 1, 'LIVRE', 4);
INSERT INTO public.mesa VALUES (2, 'M02', 2, 'OCUPADA', 6);
INSERT INTO public.mesa VALUES (3, 'M03', 3, 'LIVRE', 2);
INSERT INTO public.mesa VALUES (4, 'M04', 4, 'RESERVADA', 8);
INSERT INTO public.mesa VALUES (5, 'M05', 5, 'LIVRE', 4);
INSERT INTO public.mesa VALUES (6, 'M06', 6, 'OCUPADA', 6);
INSERT INTO public.mesa VALUES (7, 'M07', 7, 'LIVRE', 2);
INSERT INTO public.mesa VALUES (8, 'M08', 8, 'OCUPADA', 4);
INSERT INTO public.mesa VALUES (9, 'M09', 9, 'LIVRE', 2);
INSERT INTO public.mesa VALUES (10, 'M10', 10, 'OCUPADA', 6);


--
-- TOC entry 3411 (class 0 OID 25423)
-- Dependencies: 226
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pedido VALUES (1, 1, 1, '2023-07-25 12:30:00', NULL, NULL, 'Pendente', 'Sem cebola', 2);
INSERT INTO public.pedido VALUES (2, 2, 1, '2023-07-25 12:35:00', '2023-07-25 12:40:00', NULL, 'Em preparo', 'Com borda recheada', 1);
INSERT INTO public.pedido VALUES (3, 3, 1, '2023-07-25 12:38:00', NULL, NULL, 'Pendente', NULL, 3);
INSERT INTO public.pedido VALUES (4, 4, 2, '2023-07-25 13:10:00', '2023-07-25 13:15:00', NULL, 'Em preparo', NULL, 2);
INSERT INTO public.pedido VALUES (5, 5, 2, '2023-07-25 13:12:00', NULL, NULL, 'Pendente', 'Com cobertura extra', 1);
INSERT INTO public.pedido VALUES (6, 3, 2, '2023-07-25 13:18:00', NULL, NULL, 'Pendente', NULL, 1);
INSERT INTO public.pedido VALUES (7, 3, 3, '2023-07-25 13:45:00', '2023-07-25 13:50:00', NULL, 'Em preparo', NULL, 1);
INSERT INTO public.pedido VALUES (8, 1, 3, '2023-07-25 13:50:00', NULL, NULL, 'Pendente', 'Com queijo cheddar', 2);
INSERT INTO public.pedido VALUES (9, 2, 4, '2023-07-25 14:20:00', NULL, NULL, 'Pendente', 'Meia calabresa e meia frango', 1);
INSERT INTO public.pedido VALUES (10, 5, 4, '2023-07-25 14:22:00', NULL, NULL, 'Pendente', NULL, 1);


--
-- TOC entry 3397 (class 0 OID 25344)
-- Dependencies: 212
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pessoa VALUES (1, 'Fulano da Silva', '123.456.789-10', '(11) 98765-4321', '1990-05-15', 1, true);
INSERT INTO public.pessoa VALUES (2, 'Ciclana Souza', '987.654.321-10', '(21) 98765-4321', '1985-10-20', 2, true);
INSERT INTO public.pessoa VALUES (3, 'Beltrano Oliveira', '567.890.123-45', '(31) 98765-4321', '2000-02-01', 3, true);
INSERT INTO public.pessoa VALUES (4, 'John Doe', '111.222.333-44', '(41) 98765-4321', '1978-11-30', 4, true);
INSERT INTO public.pessoa VALUES (5, 'Jane Smith', '555.666.777-88', '(51) 98765-4321', '1995-08-25', 5, true);
INSERT INTO public.pessoa VALUES (6, 'Teste Pessoa', '999.888.777-66', '(61) 98765-4321', '2005-04-10', 1, true);
INSERT INTO public.pessoa VALUES (7, 'Maria Teste', '333.444.555-66', '(71) 98765-4321', '1992-12-05', 2, true);
INSERT INTO public.pessoa VALUES (8, 'João Exemplo', '777.666.555-44', '(81) 98765-4321', '1980-09-15', 3, true);
INSERT INTO public.pessoa VALUES (9, 'Ana Modelo', '222.333.444-55', '(91) 98765-4321', '1998-07-01', 4, true);
INSERT INTO public.pessoa VALUES (10, 'Carlos Amostra', '444.555.666-77', '(51) 98765-4321', '2003-03-20', 5, true);


--
-- TOC entry 3405 (class 0 OID 25393)
-- Dependencies: 220
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.produto VALUES (1, 'Hambúrguer', 'Hambúrguer com queijo e alface.', 'HB001', 5.00, 15.00, '10 minutos', NULL, 'PRATO_PRINCIPAL', true);
INSERT INTO public.produto VALUES (2, 'Pizza', 'Pizza de calabresa com borda recheada.', 'PZ001', 10.00, 25.00, '20 minutos', 'Tamanho Família', 'PRATO_PRINCIPAL', true);
INSERT INTO public.produto VALUES (3, 'Refrigerante', 'Refrigerante de cola em lata.', 'RF001', 2.00, 5.00, '1 minuto', NULL, 'BEBIDA', true);
INSERT INTO public.produto VALUES (4, 'Sorvete', 'Sorvete de chocolate com cobertura.', 'SR001', 3.50, 8.00, '5 minutos', NULL, 'SOBREMESA', true);
INSERT INTO public.produto VALUES (5, 'Salada', 'Salada mista com alface, tomate e cenoura.', 'SD001', 4.00, 12.00, '5 minutos', 'Opção vegetariana', 'PRATO_PRINCIPAL', true);


--
-- TOC entry 3403 (class 0 OID 25384)
-- Dependencies: 218
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3433 (class 0 OID 0)
-- Dependencies: 227
-- Name: cardapio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cardapio_id_seq', 4, true);


--
-- TOC entry 3434 (class 0 OID 0)
-- Dependencies: 229
-- Name: cardapioproduto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cardapioproduto_id_seq', 9, true);


--
-- TOC entry 3435 (class 0 OID 0)
-- Dependencies: 213
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_seq', 5, true);


--
-- TOC entry 3436 (class 0 OID 0)
-- Dependencies: 223
-- Name: comanda_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comanda_id_seq', 10, true);


--
-- TOC entry 3437 (class 0 OID 0)
-- Dependencies: 209
-- Name: endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endereco_id_seq', 5, true);


--
-- TOC entry 3438 (class 0 OID 0)
-- Dependencies: 215
-- Name: funcionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.funcionario_id_seq', 5, true);


--
-- TOC entry 3439 (class 0 OID 0)
-- Dependencies: 221
-- Name: mesa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mesa_id_seq', 10, true);


--
-- TOC entry 3440 (class 0 OID 0)
-- Dependencies: 225
-- Name: pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_id_seq', 10, true);


--
-- TOC entry 3441 (class 0 OID 0)
-- Dependencies: 211
-- Name: pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoa_id_seq', 10, true);


--
-- TOC entry 3442 (class 0 OID 0)
-- Dependencies: 219
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_seq', 5, true);


--
-- TOC entry 3443 (class 0 OID 0)
-- Dependencies: 217
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_seq', 1, false);


--
-- TOC entry 3244 (class 2606 OID 25447)
-- Name: cardapio cardapio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cardapio
    ADD CONSTRAINT cardapio_pkey PRIMARY KEY (id);


--
-- TOC entry 3246 (class 2606 OID 25454)
-- Name: cardapioproduto cardapioproduto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cardapioproduto
    ADD CONSTRAINT cardapioproduto_pkey PRIMARY KEY (id);


--
-- TOC entry 3230 (class 2606 OID 25363)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- TOC entry 3240 (class 2606 OID 25416)
-- Name: comanda comanda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comanda
    ADD CONSTRAINT comanda_pkey PRIMARY KEY (id);


--
-- TOC entry 3226 (class 2606 OID 25342)
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- TOC entry 3232 (class 2606 OID 25377)
-- Name: funcionario funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id);


--
-- TOC entry 3238 (class 2606 OID 25407)
-- Name: mesa mesa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mesa
    ADD CONSTRAINT mesa_pkey PRIMARY KEY (id);


--
-- TOC entry 3242 (class 2606 OID 25430)
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);


--
-- TOC entry 3228 (class 2606 OID 25349)
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);


--
-- TOC entry 3236 (class 2606 OID 25400)
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);


--
-- TOC entry 3234 (class 2606 OID 25391)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 3253 (class 2606 OID 25455)
-- Name: cardapioproduto cardapioproduto_cardapio_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cardapioproduto
    ADD CONSTRAINT cardapioproduto_cardapio_id_fkey FOREIGN KEY (cardapio_id) REFERENCES public.cardapio(id) ON DELETE CASCADE;


--
-- TOC entry 3254 (class 2606 OID 25460)
-- Name: cardapioproduto cardapioproduto_produto_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cardapioproduto
    ADD CONSTRAINT cardapioproduto_produto_id_fkey FOREIGN KEY (produto_id) REFERENCES public.produto(id) ON DELETE CASCADE;


--
-- TOC entry 3248 (class 2606 OID 25364)
-- Name: cliente cliente_pessoa_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pessoa_id_fkey FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);


--
-- TOC entry 3250 (class 2606 OID 25417)
-- Name: comanda comanda_mesa_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comanda
    ADD CONSTRAINT comanda_mesa_id_fkey FOREIGN KEY (mesa_id) REFERENCES public.mesa(id);


--
-- TOC entry 3249 (class 2606 OID 25378)
-- Name: funcionario funcionario_pessoa_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pessoa_id_fkey FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);


--
-- TOC entry 3252 (class 2606 OID 25436)
-- Name: pedido pedido_comanda_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_comanda_id_fkey FOREIGN KEY (comanda_id) REFERENCES public.comanda(id);


--
-- TOC entry 3251 (class 2606 OID 25431)
-- Name: pedido pedido_produto_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_produto_id_fkey FOREIGN KEY (produto_id) REFERENCES public.produto(id);


--
-- TOC entry 3247 (class 2606 OID 25350)
-- Name: pessoa pessoa_id_endereco_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_id_endereco_fkey FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


-- Completed on 2023-07-30 19:29:15

--
-- PostgreSQL database dump complete
--

