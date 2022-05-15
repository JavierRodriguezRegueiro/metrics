import PutMetric from './api/PutMetric';
import GetMetricsInRange from './api/GetMetricsInRange';
import './App.css';

function App() {
  return (
    <div className="App" data-testid="app">
      <button onClick={() => PutMetric.request("1234", "name", "value")}>Put</button>
      <button onClick={() => GetMetricsInRange.request("12", "12345")}>Get</button>
    </div>
  );
}

export default App;
