# react-hook-example

Custom hook: function useLocalStorage(key, initial) { const [value, setValue] = useState(() => localStorage.getItem(key) || initial); useEffect(() => localStorage.setItem(key, value), [key, value]); return [value, setValue]; }
