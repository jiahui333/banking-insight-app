/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      fontFamily: {
        'logoFont': ['Inconsolata', 'monospace'],
        'bodyFont': ['Montserrat', 'sans-serif']
      },
    },
  },
  plugins: [],
}