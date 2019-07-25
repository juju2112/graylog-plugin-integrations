const DEFAULT_SETTINGS = {
  /*
  fieldId: { // Same ID as supplied to <Input />
    value: '',
    defaultValue: '', // Update StepReview.jsx & relevant step(s) if you need to output
  }
  */

  /* Default Advanced Settings */
  awsCloudWatchBatchSize: {
    defaultValue: '10000',
  },
  awsCloudWatchThrottleWait: {
    defaultValue: '1000',
  },
};

export const awsAuth = ({ awsCloudWatchAwsKey, awsCloudWatchAwsSecret }) => {
  /*
    For development, create a sibling file named `aws.js` in the current directory.
    ```module.exports = { key: 'YOUR_REAL_KEY', secret: 'YOUR_REAL_SECRET' };```
    This file is already set in .gitignore so it won't be commited
  */

  const auth = { key: awsCloudWatchAwsKey.value, secret: awsCloudWatchAwsSecret.value };

  try {
    // eslint-disable-next-line global-require
    const realAuth = require('./aws');
    return { ...auth, ...realAuth };
  } catch (e) {
    return auth;
  }
};

export default DEFAULT_SETTINGS;