# pytest-example

Pytest example: def test_add(): assert add(2, 3) == 5. @pytest.mark.parametrize('a,b,expected', [(1,2,3), (0,0,0)]). def test_add_param(a, b, expected): assert add(a, b) == expected. @pytest.fixture. def sample_data(): return {'name': 'test'}.
