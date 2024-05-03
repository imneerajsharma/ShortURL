import React, { useState } from 'react';
import axios from 'axios';
import '../styles.css';

const Home = () => {
  const [originalUrl, setOriginalUrl] = useState('');
  const [shortenedUrl, setShortenedUrl] = useState('');
  const [error, setError] = useState('');

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     console.log('Form submitted');
//     try {
//       const response = await axios.post('http://localhost:8080/generate', { originalUrl });
//       if (response.status === 200) {
//         setShortenedUrl(response.data.shortLink);
//         setError('');
//       } else {
//         setError(response.data.message || 'An error occurred while processing your request.');
//         setShortenedUrl('');
//       }
//     } catch (error) {
//       console.error('Error:', error);
//       setError('An error occurred while processing your request.');
//       setShortenedUrl('');
//     }
//   };
const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('Form submitted');
    try {
    //   const response = await axios.post('http://localhost:8080/generate', { originalUrl });
    const response = await axios({
        method: 'post',
        url: 'http://localhost:8080/generate',
        data: {
            "url": "https://www.apple.com/ca/",
            "expirationDate":"2024-09-15T23:05:30"          
        }
      });
      console.log('Response ', response);
      if (response.status === 200) {
        setShortenedUrl(response.data.shortLink);
        setError('');
      } else {
        setError(response.data.message || 'An error occurred while processing your request.');
        setShortenedUrl('');
      }
    } catch (error) {
      console.error('Error:', error);
      setError('An error occurred while processing your request.');
      setShortenedUrl('');
    }
  };
  

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-700 ">
      <h1 className="text-4xl font-bold mb-8 text-white">Short URL Generator</h1>
      <form onSubmit={handleSubmit} className="flex items-center">
        <input
          type="text"
          placeholder="Enter URL"
          value={originalUrl}
          onChange={(e) => setOriginalUrl(e.target.value)}
          className="border border-gray-300 rounded-l py-2 px-4 focus:outline-none focus:border-blue-500 bg-white text-gray-900 "
          style={{ width: '800px' ,height: '2.5rem'}} // Adjust the width as needed
        />
        <button type="submit" className="bg-green-500 font-bold text-white py-2 px-4 rounded-r hover:bg-blue-600 focus:outline-none"
         style={{ height: '2.5rem' }}>
          Generate Short URL
        </button>
      </form >
      {error && <p className="text-red-500 mt-2">{error}</p>}
      {shortenedUrl && (
        <div className="mt-8 border border-gray-300 rounded py-2 px-4 bg-white" style={{width:"400px"}}>
          <p className="text-lg font-semibold">Shortened URL:</p>
          <a href={shortenedUrl} target="_blank" rel="noopener noreferrer" className="text-blue-500 hover:underline">{shortenedUrl}</a>
        </div>
      )}
    </div>
  );
};

export default Home;
