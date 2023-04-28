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
        'baseColor': '#15803D',
        //-80% base
        'logoColor20': '#d0e6d8',
        // +60% base
        'darkColor160': '#083318',
        // +80% base
        'bodyColor180': '#041a0c',
        // -70% base
        'lightColor30': '#b9d9c5',
      },
    },
  },
}
