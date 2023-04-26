/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      fontFamily: {
        'logoFont': ['Corben', 'serif'],
        'bodyFont': ['Montserrat', 'sans-serif']
      },
      colors: {
        //baseColor: #15803D
        'logoColor': '#d0e6d8',
        // +60% base
        'h1Color': '#083318',
        // +80% base
        'bodyColor': '#041a0c',
        // -70% base
        'lightColor': '#b9d9c5',
      },
    },
  },
}
