PGDMP     '    !            	    u            pi    9.6.3    9.6.3     [           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            \           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ]           1262    16535    pi    DATABASE     �   CREATE DATABASE pi WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE pi;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            ^           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12387    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            _           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    24944    cod_produto    SEQUENCE     m   CREATE SEQUENCE cod_produto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.cod_produto;
       public       postgres    false    3            �            1259    16536    idtarefa    SEQUENCE     j   CREATE SEQUENCE idtarefa
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.idtarefa;
       public       postgres    false    3            �            1259    24955    produto    TABLE     �   CREATE TABLE produto (
    cod integer DEFAULT nextval('cod_produto'::regclass) NOT NULL,
    nome character(100),
    descricao character(500),
    valor numeric(7,2)
);
    DROP TABLE public.produto;
       public         postgres    false    188    3            �            1259    16750    tarefa    TABLE     �   CREATE TABLE tarefa (
    id integer NOT NULL,
    descricao character(300),
    finalizacao boolean,
    data_finalizacao character(10)
);
    DROP TABLE public.tarefa;
       public         postgres    false    3            �            1259    16755 	   tarefa_id    SEQUENCE     k   CREATE SEQUENCE tarefa_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.tarefa_id;
       public       postgres    false    3            `           0    0    cod_produto    SEQUENCE SET     2   SELECT pg_catalog.setval('cod_produto', 4, true);
            public       postgres    false    188            a           0    0    idtarefa    SEQUENCE SET     /   SELECT pg_catalog.setval('idtarefa', 1, true);
            public       postgres    false    185            X          0    24955    produto 
   TABLE DATA               7   COPY produto (cod, nome, descricao, valor) FROM stdin;
    public       postgres    false    189   �       U          0    16750    tarefa 
   TABLE DATA               G   COPY tarefa (id, descricao, finalizacao, data_finalizacao) FROM stdin;
    public       postgres    false    186   �       b           0    0 	   tarefa_id    SEQUENCE SET     0   SELECT pg_catalog.setval('tarefa_id', 4, true);
            public       postgres    false    187            �           2606    24963    produto produto_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (cod);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public         postgres    false    189    189            �           2606    16754    tarefa tarefa_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY tarefa
    ADD CONSTRAINT tarefa_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.tarefa DROP CONSTRAINT tarefa_pkey;
       public         postgres    false    186    186            X   y   x�3�(�O)-�W0T��tI-N.�<����|��|�:�9
p�YZr�Ә--Ñ�hi�(p�ih
Jc��4fLK�p�1Z�9
 �1p"3�'2Zچ#����Q0� ���b���� �SX,      U   6   x�3�I,JMKTI-.IUxgg��	'4�L�AC p�p"8\1z\\\ `S�     