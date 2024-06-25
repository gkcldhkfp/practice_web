
insert into albums (album_name, album_image, album_type, album_release_date) 
    values ('tight', '/images/10cm-tight.jpg', 'single', to_date('2020-09-22','YYYY-MM-DD'));

insert into songs (album_id, title, song_path, lyrics, video_link, genre) 
    values (1, 'tight', '/songs/Tight.mp3', '/lyrics/tight.txt', 'https://www.youtube.com/embed/-xm5GpFwHw4?si=dnpbVkGM_7k3EMSR', 'folk');

insert into composers (song_id, composer) values (1, '이아일'); -- 작곡가
insert into composers (song_id, composer) values (1, '박문치');
insert into composers (song_id, composer) values (1, 'noday');

insert into singers (song_id, singer_name) values (1, '10CM'); -- 가수

insert into writers (song_id, writer) values (1,'10CM');-- 작사
insert into writers (song_id, writer) values (1,'이아일');
insert into writers (song_id, writer) values (1,'박문치');
insert into writers (song_id, writer) values (1,'noday');
insert into writers (song_id, writer) values (1,'달총');

insert into arrangers (song_id, arranger) values (1,'박문치');-- 편곡

UPDATE songs SET title = 'Tight' WHERE title = 'tight';

commit;

SELECT
    s.title AS song_title,
    a.album_name,
    a.album_image,
    s.genre,
    si.singer_name,
    LISTAGG(DISTINCT wr.writer, ', ') WITHIN GROUP (ORDER BY wr.writer) AS writers,
    LISTAGG(DISTINCT co.composer, ', ') WITHIN GROUP (ORDER BY co.composer) AS composers,
    LISTAGG(DISTINCT ar.arranger, ', ') WITHIN GROUP (ORDER BY ar.arranger) AS arrangers,
    s.lyrics
FROM
    songs s
JOIN
    albums a ON s.album_id = a.album_id
LEFT JOIN
    singers si ON s.song_id = si.song_id
LEFT JOIN
    writers wr ON s.song_id = wr.song_id
LEFT JOIN
    composers co ON s.song_id = co.song_id
LEFT JOIN
    arrangers ar ON s.song_id = ar.song_id
WHERE
    s.song_id = 1
GROUP BY
    s.title,
    a.album_name,
    a.album_image,
    s.genre,
    si.singer_name,
    s.lyrics;

update songs set lyrics = '/static/lyrics/tight.txt' where song_id = 1;

commit;




    
    

