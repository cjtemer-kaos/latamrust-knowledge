# react-custom-hooks

Custom hooks: function useFetch(url) { const [data, setData] = useState(null); useEffect(() => { fetch(url).then(r => r.json()).then(setData); }, [url]); return data; } Rules: 1) Start with 'use'. 2) Call at top level. 3) Only from React functions. 4) Return consistent shapes.
