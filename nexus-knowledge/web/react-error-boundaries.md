# react-error-boundaries

Error boundaries: class ErrorBoundary extends React.Component { state = {hasError: false}; static getDerivedStateFromError(error) { return {hasError: true}; } componentDidCatch(error, info) { logError(error, info); } render() { if (this.state.hasError) return <Fallback/>; return this.props.children; } }
