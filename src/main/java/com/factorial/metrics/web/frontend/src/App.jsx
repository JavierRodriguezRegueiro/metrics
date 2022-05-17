import PutMetric from './api/PutMetric';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import GetMetricsInRange from './api/GetMetricsInRange';
import PutMetricForm from "./components/PutMetricForm/PutMetricForm";
import GetMetrics from "./components/GetMetrics/GetMetrics";
import './App.css';

function App() {
  return (
    <LocalizationProvider dateAdapter={AdapterDateFns}>
      <div className="App" data-testid="app">
        <PutMetricForm currentDate={new Date()}/>
        <GetMetrics />
      </div>
    </LocalizationProvider>
  );
}

export default App;
