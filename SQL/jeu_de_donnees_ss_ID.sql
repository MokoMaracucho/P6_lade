INSERT INTO utilisateur
    (prenom_utilisateur, 	nom_utilisateur, 	email_utilisateur,					      mot_de_passe_utilisateur, 										                numero_membre_utilisateur, 		date_inscription_utilisateur)
VALUES
    ('Federico', 			    'Desmoulin', 		  'desmoulin.federico@gmail.com', 	'9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 	123456,							          '2020-02-01 11:11:11'),
    ('Mathieu', 			      'Desmoulin', 		  'desmoulin.mathieu@gmail.com', 		'9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 	null,							            '2020-02-01 11:12:11'),
    ('Guy', 				        'Desmoulin', 		  'desmoulin.guy@gmail.com', 			  '9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 	null,							            '2020-02-01 11:13:11'),
    ('Eugenia', 			      'Gomez', 			    'gomez.eugenia@gmail.com', 			  '9sVRxJqDHijMXpEOHUbWhNvmuRZ7ci/XnYXzMdMkRVixCw3eIPUusQ==', 	null,							            '2020-02-01 11:14:11');

INSERT INTO site
    (id_utilisateur, 		nom_site, 						       region_site)
VALUES
    ('1', 					     'Le chemin de la Marmotte', 	 'Provence-Alpes-Côte d''Azur'),
    ('2', 					     'Le Pic', 						         'Auvergne-Rhône-Alpes');

INSERT INTO secteur
    (id_utilisateur, 	id_site, 		nom_secteur)
VALUES
    ('1', 					       '1',			    'La Petite Marmotte'),
    ('3', 					       '1',			    'La Grande Marmotte'),
    ('2', 					       '2',			    'Le Vertigineux'),
    ('2', 					       '2',			    'Le Grandiose');

INSERT INTO voie
    (id_utilisateur, 	id_secteur, 	nom_voie, 						        equipe_voie, 	 cotation_voie)
VALUES
    ('1', 					    '1',			    'Le réveil de la Marmotte',   '1', 			     '4'),
    ('3', 					    '2',			    'L''éffroyable Marmotte', 		'0',			   '6b'),
    ('2', 					    '3',			    'Pour commencer',		 		      '0',			     '7'),
    ('2', 					    '4',			    'Le Panorama'	,		 		        '0',			     '8a');

INSERT INTO longueur
    (id_utilisateur, 	 id_voie, 	nom_longueur, 	cotation_longueur)
VALUES
    ('1', 					     '1',		    'Longueur 1', 	'4b'),
    ('1', 					     '1',		    'Longueur 2', 	'5a'),
    ('1', 					     '1',		    'Longueur 3', 	'5b'),
    ('1', 					     '1',		    'Longueur 4', 	'5a'),
    ('3', 					     '2',		    'Longueur 1', 	'6b'),
    ('4', 					     '2',		    'Longueur 2', 	'5c'),
    ('4', 					     '2',		    'Longueur 3', 	'6a'),
    ('4', 					     '2',		    'Longueur 4', 	'6a'),
    ('2', 					     '3',		    'Longueur 1', 	'6c'),
    ('2', 					     '3',		    'Longueur 2', 	'7a'),
    ('2', 					     '3',		    'Longueur 3', 	'7b'),
    ('2', 					     '3',		    'Longueur 4', 	'7a'),
    ('2', 					     '4',		    'Longueur 1', 	'7c'),
    ('2', 					     '4',		    'Longueur 2', 	'8a'),
    ('2', 					     '4',		    'Longueur 3', 	'8b'),
    ('2', 					     '4',		    'Longueur 4', 	'8a');

INSERT INTO commentaire
    (id_utilisateur, 	id_site, 	commentaire)
VALUES
    ('1', 						  '1',			'Pour les débutants'),
    ('2', 						  '1',		  'Trop facile...'),
    ('4', 						  '1',			'Pas pour tout le monde !!!'),
    ('2', 						  '2',			'A la pointe !'),
    ('1', 						  '2',			'Quelle vue...'),
    ('3', 						  '2',			'Pas facile...');
