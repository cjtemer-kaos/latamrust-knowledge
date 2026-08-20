# pydantic-settings

pydantic-settings: from pydantic_settings import BaseSettings. class Settings(BaseSettings): database_url: str; api_key: str; debug: bool = False. settings = Settings(). Reads from env vars, .env file. Validation: fails fast on missing required. Types: converts strings to correct types.
