import {v4 as uuid} from 'uuid'

class PutMetric {
  async request(timestamp, name, value) {
    const options = {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        timestamp: timestamp,
        name: name,
        value: value
      })
    }
    return fetch(`http://localhost:8080/metrics/${uuid()}`, options)
  }
}

export default new PutMetric();
