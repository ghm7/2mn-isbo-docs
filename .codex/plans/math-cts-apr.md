# Math CTS Formula Sheet Plan

Create a one-side printable Markdown sheet for the math test on Tuesday, 2026-04-28,
based mainly on matematicas-cts/04242026.md:1 and the recent algebra practice in
matematicas-cts.

The sheet should focus on: desarrollar, factorizar, operatoria, ecuaciones de 1er grado,
ecuaciones de 2do grado, identidades, and examples.

## Output

- Create matematicas-cts/escrito-formulas-2026-04-28.md.
- Format: compact printable Markdown with LaTeX formulas.
- Target: one printed side, dense but readable.
- Language: Spanish.
- Include formulas first, then tiny solved examples.

## Key Content

- Operatoria base: conmutativa, asociativa, neutro, inverso multiplicativo,
  distributiva.
- Potencias: same base x^m x^n = x^{m+n}, same exponent a^n b^n = (ab)^n, warnings about
  parentheses like -2^2 vs (-2)^2.
- Identidades notables:
  (a+b)^2, (a-b)^2, (a+b)(a-b), and scalar form k(a+b)(a-b)=ka^2-kb^2.
- Factorización: common factor, difference of squares, perfect-square trinomials, and
  product-zero rule.
- Ecuaciones: first-degree isolation, incomplete second-degree equations, and Bhaskara:
  x = (-b ± sqrt(b^2 - 4ac)) / 2a.
- Examples to include:
  35x^2+25x=0, (3x+2)(3x-2), (x+5)^2-(x-3)^2, and one Bhaskara example.
- Accuracy pass: do not blindly copy note mistakes; verify examples like x^2-4x+3 = (x-
  1)(x-3).

## Test Plan

- Check every formula by expanding/factoring one example.
- Verify solved examples give correct roots when substituted back.
- Confirm the sheet prints on one side without formulas wrapping badly.
- Ensure the final sheet includes no unrelated puzzle material from early March notes.

## Assumptions

- The teacher allows one printed side.
- The PDF handout in the folder is secondary; use the Markdown notes as the source of
  truth unless OCR/manual review is added.
- Since 04242026.md says “Para el escrito,” its topic list has highest priority.
