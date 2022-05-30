import {render} from '@testing-library/react';
import MetricsTimeLine from "../MetricsTimeLine";

describe('<MetricsTimeLine />', () => {
  it('should be render without crash with hours', () => {
    const {container} = render(<MetricsTimeLine
      metrics={[{name: 'test', id: 'id'}]}
      initialDate={"1653947011240"}
      endDate={"1653947011240"}
      order={{
        value: 'hours',
        label: 'Hours',
        sections: 24
      }}
    />)
    expect(container).toBeInTheDocument();
  })
});
