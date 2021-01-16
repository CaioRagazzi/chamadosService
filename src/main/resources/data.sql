INSERT INTO chamados_db.tipo_chamado (id_tipo_chamado, descricao)
SELECT  1, 'incidente'
WHERE   NOT EXISTS 
        (   SELECT  1
            FROM    chamados_db.tipo_chamado
            WHERE   id_tipo_chamado = 1
        );
        
INSERT INTO chamados_db.tipo_chamado (id_tipo_chamado, descricao)
SELECT  2, 'requisição'
WHERE   NOT EXISTS 
        (   SELECT  1
            FROM    chamados_db.tipo_chamado
            WHERE   id_tipo_chamado = 2
        );
        
INSERT INTO chamados_db.status_chamado (id_status_chamado, descricao)
SELECT  1, 'aberto'
WHERE   NOT EXISTS 
        (   SELECT  1
            FROM    chamados_db.status_chamado
            WHERE   id_status_chamado = 1
        );
        
INSERT INTO chamados_db.status_chamado (id_status_chamado, descricao)
SELECT  2, 'em atendimento'
WHERE   NOT EXISTS 
        (   SELECT  1
            FROM    chamados_db.status_chamado
            WHERE   id_status_chamado = 2
        );
    
INSERT INTO chamados_db.status_chamado (id_status_chamado, descricao)
SELECT  3, 'encerrado'
WHERE   NOT EXISTS 
        (   SELECT  1
            FROM    chamados_db.status_chamado
            WHERE   id_status_chamado = 3
        );
        
INSERT INTO chamados_db.status_chamado (id_status_chamado, descricao)
SELECT  4, 'cancelado'
WHERE   NOT EXISTS 
        (   SELECT  1
            FROM    chamados_db.status_chamado
            WHERE   id_status_chamado = 4
        );