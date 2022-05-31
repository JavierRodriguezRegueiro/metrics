import {act, render, screen} from '@testing-library/react';
import PutMetricForm from '../PutMetricForm';
import PutMetric from '../../../api/PutMetric';
import { Simulate } from 'react-dom/test-utils';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';

const date = new Date();
const EncapsulatePutMetricForm = () => {
  return (
    <LocalizationProvider dateAdapter={AdapterDateFns}>
      <PutMetricForm currentDate={date} />)
    </LocalizationProvider>
  );
}


describe('<PutMetricForm />', () => {
  beforeAll(() => {
    PutMetric.request = jest.fn();
  })

  beforeEach(() => {
    PutMetric.request.mockClear();
  })

  it('should render without crash', () => {
    const {container} = render(<EncapsulatePutMetricForm />);
    expect(container).toBeInTheDocument();
  });

  it('should call PutMetric function on click in ok button', () => {
    const { getByText } = render(<EncapsulatePutMetricForm />);
    const okButton = getByText('Ok');
    okButton.click();
    expect(PutMetric.request).toHaveBeenCalledTimes(1);
  })

  it('should call PutMetric with input values', async () => {
    render(<EncapsulatePutMetricForm />);
    await act(() => {
      fillInput('putMetricForm-name', 'name');
    });
    await act(() => {
      fillInput('putMetricForm-value', 'value');
    });
    const okButton = screen.getByText('Ok');
    await act(() => {
      okButton.click();
    })
    expect(PutMetric.request).toHaveBeenCalledWith(date.getTime(), 'name', 'value');
  })

  it('should call PutMetric with input values', async () => {
    render(<EncapsulatePutMetricForm />);
    await act(async () => {
      await fillInput('putMetricForm-name', 'name');
    });
    await act( async () => {
      await fillInput('putMetricForm-value', 'value');
    });
    const okButton = screen.getByText('Cancel');
    await act( async () => {
      await okButton.click();
    })

    expect(screen.getByTestId('putMetricForm-name').value).toBe('');
    expect(screen.getByTestId('putMetricForm-value').value).toBe('');
  })
})

async function fillInput(inputTestId, value) {
  const input = screen.getByTestId(inputTestId);
  input.value = value;
  await act(() => {
    Simulate.change(input);
  });
}
