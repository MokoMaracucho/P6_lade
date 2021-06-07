INSERT INTO utilisateur
    (id_utilisateur,    prenom_utilisateur, 	nom_utilisateur, 	email_utilisateur,					      mot_de_passe_utilisateur, 										                numero_membre_utilisateur, 		date_inscription_utilisateur)
VALUES
    (1,                 'Federico', 			    'Desmoulin', 		  'desmoulin.federico@gmail.com', 	'9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 	123456,							          '2020-02-01 11:11:11'),
    (2,                 'Mathieu', 			      'Desmoulin', 		  'desmoulin.mathieu@gmail.com', 		'9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 	null,							            '2020-02-01 11:12:11'),
    (3,                 'Guy', 				        'Desmoulin', 		  'desmoulin.guy@gmail.com', 			  '9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 	null,							            '2020-02-01 11:13:11'),
    (4,                 'Eugenia', 			      'Gomez', 			    'gomez.eugenia@gmail.com', 			  '9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 	null,							            '2020-02-01 11:14:11');

INSERT INTO site
    (id_site, id_utilisateur, 		nom_site, 						       region_site)
VALUES
    ('1',     '1', 					     'Le chemin de la Marmotte', 	 'Provence-Alpes-Côte d''Azur'),
    ('2',     '2', 					     'Le Pic', 						         'Auvergne-Rhône-Alpes');

INSERT INTO secteur
    (id_secteur,  id_utilisateur, 	id_site, 		nom_secteur)
VALUES
    ('1',         '1', 					       '1',			    'La Petite Marmotte'),
    ('2',         '3', 					       '1',			    'La Grande Marmotte'),
    ('3',         '2', 					       '2',			    'Le Vertigineux'),
    ('4',         '2', 					       '2',			    'Le Grandiose');

INSERT INTO voie
    (id_voie,   id_utilisateur, 	id_secteur, 	nom_voie, 						        equipe_voie, 	 cotation_voie)
VALUES
    ('1',       '1', 					    '1',			    'Le réveil de la Marmotte',   '1', 			     '4'),
    ('2',       '3', 					    '2',			    'L''éffroyable Marmotte', 		'0',			   '6b'),
    ('3',       '2', 					    '3',			    'Pour commencer',		 		      '0',			     '7'),
    ('4',       '2', 					    '4',			    'Le Panorama'	,		 		        '0',			     '8a');

INSERT INTO longueur
    (id_longueur,   id_utilisateur, 	 id_voie, 	nom_longueur, 	cotation_longueur)
VALUES
    ('1',           '1', 					     '1',		    'Longueur 1', 	'4b'),
    ('2',           '1', 					     '1',		    'Longueur 2', 	'5a'),
    ('3',           '1', 					     '1',		    'Longueur 3', 	'5b'),
    ('4',           '1', 					     '1',		    'Longueur 4', 	'5a'),
    ('5',           '3', 					     '2',		    'Longueur 1', 	'6b'),
    ('6',           '4', 					     '2',		    'Longueur 2', 	'5c'),
    ('7',           '4', 					     '2',		    'Longueur 3', 	'6a'),
    ('8',           '4', 					     '2',		    'Longueur 4', 	'6a'),
    ('9',           '2', 					     '3',		    'Longueur 1', 	'6c'),
    ('10',          '2', 					     '3',		    'Longueur 2', 	'7a'),
    ('11',          '2', 					     '3',		    'Longueur 3', 	'7b'),
    ('12',          '2', 					     '3',		    'Longueur 4', 	'7a'),
    ('13',          '2', 					     '4',		    'Longueur 1', 	'7c'),
    ('14',          '2', 					     '4',		    'Longueur 2', 	'8a'),
    ('15',          '2', 					     '4',		    'Longueur 3', 	'8b'),
    ('16',          '2', 					     '4',		    'Longueur 4', 	'8a');

INSERT INTO commentaire
    (id_commentaire,  id_utilisateur, 	id_site, 	commentaire)
VALUES
    ('1',             '1', 						  '1',			'Pour les débutants'),
    ('2',             '2', 						  '1',		  'Trop facile...'),
    ('3',             '4', 						  '1',			'Pas pour tout le monde !!!'),
    ('4',             '2', 						  '2',			'A la pointe !'),
    ('5',             '1', 						  '2',			'Quelle vue...'),
    ('6',             '3', 						  '2',			'Pas facile...');
