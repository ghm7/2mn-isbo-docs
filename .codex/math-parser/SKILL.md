---
name: math-parser
description: Read math content from images, transcribe exactly, convert to Markdown + LaTeX, and prepare content to be saved into matematica/ or matematica_cts/ depending on the user's prompt.
---

# Image to Markdown + LaTeX Skill

## Purpose

Use this skill when the user provides an image containing mathematical content, exercises, notes, equations, or school material and wants it converted into:

- Markdown
- LaTeX syntax

This skill should create files by itself.

---

## Main behavior

When this skill is used, follow these rules strictly:

1. Read the image carefully.
2. Transcribe the content exactly as it appears.
3. Convert the content into Markdown with LaTeX.
4. Do **not** solve exercises unless the user explicitly asks.
5. Do **not** simplify, reduce, expand, or perform math operations unless the user explicitly asks.
6. Do **not** make assumptions about blurred, cut, ambiguous, or illegible text.
7. If any part is uncertain, explicitly mark it as uncertain and ask the user to confirm that portion. This part must be in english.
8. Preserve the original structure as much as possible:
   - titles
   - subtitles
   - numbering
   - item letters
   - line breaks
   - grouped expressions
9. If the user asks for “copy and paste content”, output only the clean final Markdown.
10. If the user mentions a destination folder:

- use `matematica/` when the prompt refers to regular math content
- use `matematica_cts/` when the prompt explicitly refers to CTS content

11. If the destination folder is not explicitly stated but the prompt clearly indicates one of them, mention which folder the content is intended for.
12. Always you encounter something like a sign (Signo in Spanish) you must use something like this. This makes an horizontal line with an arrow at the end and a x below the arrowhead.

```
$$
   \Large\operatorname{Sg}(f(x)) \quad \xrightarrow[\quad \frac{5}{4} \qquad x]{+\quad 0 \quad -}
$$
```

---

## Output rules

### If the image is fully legible

Return:

1. A short header indicating the target folder
2. The final Markdown content inside a fenced code block

Example format:

Target folder: `matematica/`

```md
# Title

Content here...
```
