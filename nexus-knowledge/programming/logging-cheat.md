# logging-cheat

logging: import logging. logging.basicConfig(level=logging.INFO). logger = logging.getLogger(__name__). logger.info('msg'). logger.error('err', exc_info=True). logging.FileHandler('app.log'). logging.Formatter('%(asctime)s %(levelname)s %(message)s').
