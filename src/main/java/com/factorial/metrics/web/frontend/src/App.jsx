import PutMetric from './api/PutMetric';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import GetMetricsInRange from './api/GetMetricsInRange';
import PutMetricForm from "./components/PutMetricForm/PutMetricForm";
import './App.css';

function App() {
  return (
    <LocalizationProvider dateAdapter={AdapterDateFns}>
      <div className="App" data-testid="app">
        <button onClick={() => PutMetric.request("1234", "name", "value")}>Put</button>
        <button onClick={() => GetMetricsInRange.request("12", String(Date.now()))}>Get</button>
        <PutMetricForm currentDate={new Date()}/>
      </div>
    </LocalizationProvider>
  );
}

export default App;
