create database hospital;
use Hospital;
create table Atendimento(
	idAtendimento integer not null auto_increment,
    comentarioEnfermeiro varchar(100),
    comentarioMedico varchar(100),
    peso float,
    altura float,
    dataAtendimento date,
    doenca varchar(100),
    constraint PK_Atendimento PRIMARY KEY(idAtendimento)
);    
create table Enfermidade(
	idEnfermidade integer not null auto_increment,
    nome varchar(100),
    tipo varchar(100),
    descricao varchar(500),
    constraint PK_Enfermidade PRIMARY KEY(idEnfermidade)
);
/*Tabela Medico com itens da tabela Pessoa e funcionario */   
create table Medico(
	idMedico integer not null auto_increment,
	nome varchar(100),
    cpf varchar(11),
    idade integer,
    tipoSanguineo varchar(10),
    sexo varchar(10),
    statusPessoa varchar(100),
    login varchar(100),
    senha varchar(100),
    statusUsuario varchar(100),
	numeroRegistro integer,
    especialidade varchar(100),
    constraint PK_Medico PRIMARY KEY(idMedico));
/*Tabela Paciente com itens da tabela Pessoa*/   
create table Paciente(
	idPaciente integer not null auto_increment,
    nome varchar(100),
    cpf varchar(11),
    idade integer,
    tipoSanguineo varchar(10),
    sexo varchar(10),
    statusPessoa varchar(100),
    doenca varchar(100),
    historico varchar(100),
    constraint PK_Paciente PRIMARY KEY(idPaciente));
/*Tabela Funcionario com itens da tabela Pessoa*/  
create table Funcionario(
    idFuncionario integer auto_increment,
    login varchar(100),
    senha varchar(100),
    statusUsuario varchar(100),
     nome varchar(100),
    cpf varchar(11),
    idade integer,
    tipoSanguineo varchar(10),
    sexo varchar(10),
    statusPessoa varchar(100),
    constraint PK_Funcionario PRIMARY KEY(idFuncionario));
/*Tabela Gerente com itens da tabela Pessoa*/  
create table Gerente(
	idGerente integer not null auto_increment,
    nome varchar(100),
    cpf varchar(11),
    idade integer,
    tipoSanguineo varchar(10),
    sexo varchar(100),
    statusPessoa varchar(100),
    login varchar(100),
    senha varchar(100),
    statusUsuario varchar(100),
    cargo varchar(100),
    constraint PK_Gerente PRIMARY KEY(idGerente));
/*Tabela Enfermeiro com itens da tabela Pessoa e funcionario*/ 
create table Enfermeiro(
	idEnfermeiro integer not null auto_increment,
	nome varchar(100),
    cpf integer,
    idade integer,
    tipoSanguineo varchar(10),
    sexo varchar(10),
    statusPessoa varchar(100),
    login varchar(100),
    senha varchar(100),
    statusUsuario varchar(100),
    numRegistro varchar(100),
    constraint PK_Enfermeiro PRIMARY KEY(idEnfermeiro));
/*tabela Entrada com itens da tabela Atendimento*/
create table Entrada(
	idEntrada integer auto_increment,
	entrada date,
    saida date,
    comentarioEnfermeiro varchar(100),
    comentarioMedico varchar(100),
    doenca varchar(100),
	situacaoPaciente varchar(100),
	statusEntrada varchar(100),
    altura float,
    peso float,
    dataAtendimento date,
    constraint PK_Entrada PRIMARY KEY(idEntrada));
/*tabela EnfermidadePessoal com itens da tabela Enfermidade*/
    create table EnfermidadePessoal(
	idEnfermidadePessoal integer not null auto_increment,
    nome varchar(100),
    tipo varchar(100),
    descricao varchar(500),
    comentario varchar(100),
    statusEnfermidade varchar(100),
    constraint PK_EnfermidadePessoal PRIMARY KEY(idEnfermidadePessoal)
);
create table Login(
    idLogin integer auto_increment,
    login varchar(100),
    senha varchar(100),
    constraint PK_Funcionario PRIMARY KEY(idLogin));
    /*
select * From Medico;
select * From Paciente;
select * From Funcionario;
select * From Gerente;
select * From Enfermeiro;
select * From Login;
select * From Entrada;
select * From EnfermidadePessoal;
select * From Atendimento;
select * From Enfermidade;
*/
