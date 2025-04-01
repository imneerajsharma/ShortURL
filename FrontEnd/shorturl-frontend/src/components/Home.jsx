import React, { useState } from 'react';
import axios from 'axios';

const Home = () => {
  const [originalUrl, setOriginalUrl] = useState('');
  const [shortenedUrl, setShortenedUrl] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('Form submitted');
    try {
      const response = await axios({
        method: 'post',
        url: 'http://localhost:8080/generate',
        data: {
          "url": originalUrl,
          "expirationDate": "2024-09-15T23:05:30"
        }
      });
      console.log('Response ', response);
      if (response.status === 200) {
        setShortenedUrl(response.data.shortLink);
        setError('');
        const shortLinkWithLocalhost = response.data.shortLinkwith_localhost;
        setShortenedUrl(shortLinkWithLocalhost);
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
    <div className="flex flex-col items-center justify-center min-h-screen bg-zinc-900 text-white">
      <h1 className="text-4xl font-bold mb-8">Short URL Generator</h1>
      <form onSubmit={handleSubmit} className="flex items-center mb-4">
        <button type="submit" className="bg-green-500 mr-2 hover:bg-green-600 text-white font-bold py-2 px-4 rounded-l focus:outline-none" style={{ height: '2.5rem' }}>
          Generate Short URL
        </button>
        <input
          type="text"
          placeholder="Enter URL"
          value={originalUrl}
          onChange={(e) => setOriginalUrl(e.target.value)}
          className="border border-gray-300 rounded-r py-2 px-4 focus:outline-none bg-white text-gray-900"
          style={{ width: '400px', height: '2.5rem' }} // Adjust the width as needed
        />
      </form>

      {shortenedUrl && (
        <div className="flex items-center mt-4">
          <p className="text-lg font-semibold mr-2 bg-green-500 text-white py-2 px-4 rounded-l" style={{ height: '2.5rem' }}>Shortened URL:</p>
          <a href={shortenedUrl} target="_blank" rel="noopener noreferrer" className="bg-white text-black py-2 px-4 mr-2 rounded-r focus:outline-none" style={{ height: '2.5rem' }}>{shortenedUrl}</a>
        </div>
      )}

      {error && <p className="text-red-500 mt-2">{error}</p>}
    </div>
  );
};

export default Home;
