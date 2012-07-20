
    alter table InstalledSoftware 
        drop 
        foreign key FKB0732321D91B5D10

    alter table InstalledSoftware 
        drop 
        foreign key FKB07323216046DD10

    alter table Project 
        drop 
        foreign key FK50C8E2F9410275A8

    alter table Project_Server 
        drop 
        foreign key FKC6B09B69781893A3

    alter table Project_Server 
        drop 
        foreign key FKC6B09B69F6760AA3

    alter table SystemUser 
        drop 
        foreign key FK9D23FEBAD91B5D10

    drop table if exists InstalledSoftware

    drop table if exists OperatingSystem

    drop table if exists Project

    drop table if exists Project_Server

    drop table if exists Server

    drop table if exists Software

    drop table if exists SystemUser

    drop table if exists User

    create table InstalledSoftware (
        id bigint not null auto_increment,
        path varchar(255),
        version varchar(255),
        server_id bigint,
        software_id bigint,
        primary key (id)
    )

    create table OperatingSystem (
        id bigint not null auto_increment,
        description varchar(255),
        primary key (id)
    )

    create table Project (
        id bigint not null auto_increment,
        creation datetime,
        description varchar(255),
        name varchar(255),
        owner_id bigint,
        primary key (id)
    )

    create table Project_Server (
        projects_id bigint not null,
        servers_id bigint not null
    )

    create table Server (
        id bigint not null auto_increment,
        description varchar(255),
        ip varchar(255),
        name varchar(255),
        primary key (id)
    )

    create table Software (
        id bigint not null auto_increment,
        description varchar(255),
        primary key (id)
    )

    create table SystemUser (
        id bigint not null auto_increment,
        password varchar(255),
        user varchar(255),
        server_id bigint,
        primary key (id)
    )

    create table User (
        id bigint not null auto_increment,
        login varchar(255),
        name varchar(255),
        password varchar(255),
        primary key (id)
    )

    alter table InstalledSoftware 
        add index FKB0732321D91B5D10 (server_id), 
        add constraint FKB0732321D91B5D10 
        foreign key (server_id) 
        references Server (id)

    alter table InstalledSoftware 
        add index FKB07323216046DD10 (software_id), 
        add constraint FKB07323216046DD10 
        foreign key (software_id) 
        references Software (id)

    alter table Project 
        add index FK50C8E2F9410275A8 (owner_id), 
        add constraint FK50C8E2F9410275A8 
        foreign key (owner_id) 
        references User (id)

    alter table Project_Server 
        add index FKC6B09B69781893A3 (servers_id), 
        add constraint FKC6B09B69781893A3 
        foreign key (servers_id) 
        references Server (id)

    alter table Project_Server 
        add index FKC6B09B69F6760AA3 (projects_id), 
        add constraint FKC6B09B69F6760AA3 
        foreign key (projects_id) 
        references Project (id)

    alter table SystemUser 
        add index FK9D23FEBAD91B5D10 (server_id), 
        add constraint FK9D23FEBAD91B5D10 
        foreign key (server_id) 
        references Server (id)
