# py-database-crud

DB CRUD: from sqlalchemy import create_engine, Column, Integer, String; engine = create_engine('sqlite:///db.sqlite'); session = sessionmaker(bind=engine)(); session.add(User(name='John')); session.commit(); user = session.query(User).filter_by(name='John').first().
