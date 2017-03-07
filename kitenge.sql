--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cart; Type: TABLE; Schema: public; Owner: pauline
--

CREATE TABLE cart (
    id integer NOT NULL,
    userid integer,
    items integer,
    kitengeid integer
);


ALTER TABLE cart OWNER TO pauline;

--
-- Name: cart_id_seq; Type: SEQUENCE; Schema: public; Owner: pauline
--

CREATE SEQUENCE cart_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cart_id_seq OWNER TO pauline;

--
-- Name: cart_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pauline
--

ALTER SEQUENCE cart_id_seq OWNED BY cart.id;


--
-- Name: designer; Type: TABLE; Schema: public; Owner: pauline
--

CREATE TABLE designer (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE designer OWNER TO pauline;

--
-- Name: designer_id_seq; Type: SEQUENCE; Schema: public; Owner: pauline
--

CREATE SEQUENCE designer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE designer_id_seq OWNER TO pauline;

--
-- Name: designer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pauline
--

ALTER SEQUENCE designer_id_seq OWNED BY designer.id;


--
-- Name: kitenge; Type: TABLE; Schema: public; Owner: pauline
--

CREATE TABLE kitenge (
    id integer NOT NULL,
    name character varying,
    description character varying,
    size character varying,
    type character varying,
    quantity integer,
    price integer,
    designerid integer,
    imgurl character varying
);


ALTER TABLE kitenge OWNER TO pauline;

--
-- Name: kitenge_id_seq; Type: SEQUENCE; Schema: public; Owner: pauline
--

CREATE SEQUENCE kitenge_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE kitenge_id_seq OWNER TO pauline;

--
-- Name: kitenge_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pauline
--

ALTER SEQUENCE kitenge_id_seq OWNED BY kitenge.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: pauline
--

CREATE TABLE users (
    id integer NOT NULL,
    name character varying,
    email character varying,
    password character varying,
    type character varying
);


ALTER TABLE users OWNER TO pauline;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: pauline
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO pauline;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pauline
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: cart id; Type: DEFAULT; Schema: public; Owner: pauline
--

ALTER TABLE ONLY cart ALTER COLUMN id SET DEFAULT nextval('cart_id_seq'::regclass);


--
-- Name: designer id; Type: DEFAULT; Schema: public; Owner: pauline
--

ALTER TABLE ONLY designer ALTER COLUMN id SET DEFAULT nextval('designer_id_seq'::regclass);


--
-- Name: kitenge id; Type: DEFAULT; Schema: public; Owner: pauline
--

ALTER TABLE ONLY kitenge ALTER COLUMN id SET DEFAULT nextval('kitenge_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: pauline
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: cart; Type: TABLE DATA; Schema: public; Owner: pauline
--

COPY cart (id, userid, items, kitengeid) FROM stdin;
\.


--
-- Name: cart_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pauline
--

SELECT pg_catalog.setval('cart_id_seq', 1, false);


--
-- Data for Name: designer; Type: TABLE DATA; Schema: public; Owner: pauline
--

COPY designer (id, name) FROM stdin;
\.


--
-- Name: designer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pauline
--

SELECT pg_catalog.setval('designer_id_seq', 1, false);


--
-- Data for Name: kitenge; Type: TABLE DATA; Schema: public; Owner: pauline
--

COPY kitenge (id, name, description, size, type, quantity, price, designerid, imgurl) FROM stdin;
\.


--
-- Name: kitenge_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pauline
--

SELECT pg_catalog.setval('kitenge_id_seq', 63, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: pauline
--

COPY users (id, name, email, password, type) FROM stdin;
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pauline
--

SELECT pg_catalog.setval('users_id_seq', 1, false);


--
-- Name: cart cart_pkey; Type: CONSTRAINT; Schema: public; Owner: pauline
--

ALTER TABLE ONLY cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (id);


--
-- Name: designer designer_pkey; Type: CONSTRAINT; Schema: public; Owner: pauline
--

ALTER TABLE ONLY designer
    ADD CONSTRAINT designer_pkey PRIMARY KEY (id);


--
-- Name: kitenge kitenge_pkey; Type: CONSTRAINT; Schema: public; Owner: pauline
--

ALTER TABLE ONLY kitenge
    ADD CONSTRAINT kitenge_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: pauline
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

