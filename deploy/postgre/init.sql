CREATE USER wsadmin WITH PASSWORD 'wspass';
CREATE DATABASE wslab;
GRANT ALL PRIVILEGES ON DATABASE wslab TO wsadmin;

\c wslab;

CREATE TABLE IF NOT EXISTS library (
    id SERIAL PRIMARY KEY,
    title VARCHAR(256) NOT NULL,
    author VARCHAR(256) NOT NULL,
    pages INTEGER NOT NULL,
    synopsis VARCHAR(1024)
);

INSERT INTO library VALUES
    (DEFAULT, 'The Adventures of Tom Sawyer', 'Mark Twain', 512, 'Test'),
    (DEFAULT, 'War and Peace', 'Leo Tolstoy', 1225, 'Long argument test'),
    (DEFAULT, 'Lord of the Rings', 'J. R. R. Tolkien', 9250, NULL),
    (DEFAULT, 'Dune', 'Frank Herbert', 412, 'Set on the desert planet Arrakis, Dune is the story of the boy ' ||
                                            'Paul Atreides, heir to a noble family tasked with ruling an inhospitable ' ||
                                            'world where the only thing of value is the “spice” melange, a drug capable ' ||
                                            'of extending life and enhancing consciousness. Coveted across the known ' ||
                                            'universe, melange is a prize worth killing for....
When House Atreides is betrayed, the destruction of Paul’s family will set ' ||
                                            'the boy on a journey toward a destiny greater than he could ever have ' ||
                                            'imagined. And as he evolves into the mysterious man known as Muad’Dib, ' ||
                                            'he will bring to fruition humankind’s most ancient and unattainable dream. '),
    (DEFAULT, 'Hyperion', 'Dan Simmons', 482, 'In the 29th century, the Hegemony of Man comprises hundreds of planets' ||
                                              ' connected by farcaster portals. The Hegemony maintains an uneasy ' ||
                                              'alliance with the TechnoCore, a civilisation of AIs. Modified humans ' ||
                                              'known as Ousters live in space stations between stars and are engaged in ' ||
                                              'conflict with the Hegemony.
Numerous "Outback" planets have no farcasters and cannot be accessed without incurring significant time dilation. ' ||
                                              'One of these planets is Hyperion, home to structures known as ' ||
                                              'the Time Tombs, which are moving backwards in time and guarded by a ' ||
                                              'legendary creature known as the Shrike. On the eve of an Ouster ' ||
                                              'invasion of Hyperion, a final pilgrimage to the Time Tombs has been ' ||
                                              'organized. The pilgrims decide that they will each tell their tale of ' ||
                                              'how they were chosen for the pilgrimage.');

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO wsadmin;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO wsadmin;