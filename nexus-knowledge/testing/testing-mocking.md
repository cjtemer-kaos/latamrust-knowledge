# testing-mocking

Mocking en tests: from unittest.mock import patch, MagicMock. @patch('module.external_api') def test_api(mock_api): mock_api.return_value = {'status': 'ok'}. result = my_function(). assert result == expected. mock_api.assert_called_once(). Mock externos (APIs, DBs), no lógica interna.
