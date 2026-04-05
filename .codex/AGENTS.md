# Repository Guidelines

## Project Structure & Module Organization

This repository is a recompilation of high-school notes the only purpose of this is to keep a place where I can storage my notes, is organized by subject. Top-level folders such as `APT/`, `ingles/`, `matematicas-cts/`, and `sistema-operativo/` contain class notes as dated Markdown files, usually named `MMDDYYYY.md` (for example, `03252026.md`). Store supporting images, PDFs, and slides under `_assets/`, grouped by subject when possible. Java practice work lives in `programacion-avanzada/` and follows the VS Code Java layout with `src/` for sources and `bin/` for compiled output.

## Build, Test, and Development Commands

Most of the repo is plain Markdown, so there is no global build step. Use targeted commands when editing Java exercises:

```bash
javac programacion-avanzada/03102026/src/App.java -d programacion-avanzada/03102026/bin
java -cp programacion-avanzada/03102026/bin App
```

Use `rg --files` to inspect the repository quickly and `git diff --stat` to review note or asset changes before committing.

## Coding Style & Naming Conventions

Write notes in concise Markdown with clear headings and short paragraphs or lists. Keep subject files date-based and place related media in `_assets/<subject>/`. In Java files, follow the existing style: 4-space indentation, `App.java` as the entry point for each exercise, and descriptive Spanish variable names when they match the assignment language. Avoid renaming existing dated files unless the content is being reorganized deliberately.

## Commit & Pull Request Guidelines

Recent history uses short conventional-style messages such as `docs(math_cts): add hw and actividades.pdf`. Prefer `docs(<scope>): <change>` for notes/assets and a narrow scope like `docs(ingles)` or `docs(td)`. Pull requests should summarize the affected subject and date, list any added assets, and include screenshots only when formatting or embedded media rendering changed.

## Content & Asset Hygiene

Keep binary files minimal and relevant. When adding scanned images or PDFs, use descriptive filenames that match the class date or topic, and avoid duplicate uploads with slightly different names unless both versions are intentionally preserved.

## Math files

When I give you an image with notes from math, you always must generate a Markdown file with a mix of Markdown and LaTeX syntax like there's in the other files inside of matematicas and matematicas_cts.
