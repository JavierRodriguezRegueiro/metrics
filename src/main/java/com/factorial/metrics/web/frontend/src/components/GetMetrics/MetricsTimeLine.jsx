import Timeline from "@mui/lab/Timeline";
import TimelineItem from "@mui/lab/TimelineItem";
import TimelineSeparator from "@mui/lab/TimelineSeparator";
import TimelineDot from "@mui/lab/TimelineDot";
import TimelineConnector from "@mui/lab/TimelineConnector";
import TimelineContent from "@mui/lab/TimelineContent";
import {useId} from "react";

import './MetricsTimeLine.css';

const MetricsTimeLine = ({metrics, initialDate, endDate, order}) => {

  const id = useId();
  const getTotalSections = () => {
    if (order.value !== 'days') {
      return order.sections;
    }
    return new Date(endDate).getDate() - new Date(initialDate).getDate()
  }

  const generateMetricsInfoContent = (index) => {
    let metricsInfoContent;
    switch (order.value) {
      case 'hours':
        metricsInfoContent = generateMetricsInfoContentByHours(index)
        break;

      case 'minutes':
        metricsInfoContent = generateMetricsInfoContentByMinutes(index);
        break;
      default:
        metricsInfoContent = generateMetricsInfoContentByDay(index);
        break;
    }
    return metricsInfoContent;
  }

  const generateMetricsInfoContentByDay = (index) => {
    const day = new Date(initialDate).getDate() + index;
    return metrics.filter(metric => {
      return new Date(Number(metric.timestamp)).getDate() === day;
    }).map((filteredMetric, index) => {
      return metricItemInformation(filteredMetric, index)
    })
  }

  const generateMetricsInfoContentByHours = (index) => {
    return metrics.filter(metric => {
      return new Date(Number(metric.timestamp)).getHours() === index;
    }).map((filteredMetric, index) => {
      return metricItemInformation(filteredMetric, index)
    })
  }

  const generateMetricsInfoContentByMinutes = (index) => {
    return metrics.filter(metric => {
      return new Date(Number(metric.timestamp)).getMinutes() === index;
    }).map((filteredMetric, index) => {
      return metricItemInformation(filteredMetric, index)
    })
  }

  const metricItemInformation = (metric, index) => {
    return (
      <div className="metricInfo" key={index + id}>
        <p className="metricInfo-name">{`Name: ${metric.name}`}</p>
        <p className="metricInfo-value">{`Value: ${metric.value}`}</p>
      </div>
    )
  }


  const timeLineMetricsContent = (index) => {
    return (
      <div className="timeLineMetricsContent">
        <p className="timeLineMetricsContent-day">{timeLineMetricContentLabel(index)}</p>
        <div className="timeLineMetricsContent-metricsInfo">
          {generateMetricsInfoContent(index)}
        </div>
      </div>
    )
  }

  const timeLineMetricContentLabel = (index) => {
    let label;
    switch (order.value) {
      case 'days':
        const initialFormattedDate = new Date(initialDate);
        initialFormattedDate.setDate(initialFormattedDate.getDate() + index)
        label = initialFormattedDate.getDate();
        break;

      default:
        label = String(index).length === 1 ? `0${index}` : index;
    }
    return label;
  }


  return (
    <Timeline>
      {
        [...Array(getTotalSections())].map((i, index) => {
          return (
            <TimelineItem key={id + index}>
              <TimelineSeparator>
                <TimelineDot />
                <TimelineConnector />
              </TimelineSeparator>
              <TimelineContent>
                {timeLineMetricsContent(index)}
              </TimelineContent>
            </TimelineItem>
          )
        })
      }
    </Timeline>
  )
}

export default MetricsTimeLine;
